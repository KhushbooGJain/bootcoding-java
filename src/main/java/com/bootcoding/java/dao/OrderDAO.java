package com.bootcoding.java.dao;

import com.bootcoding.java.model.Order;
import com.bootcoding.java.model.OrderStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private Connection conn;
    private static final String TABLE_NAME = "Customer_order";

    public OrderDAO() {
        DAOService daoService = new DAOService();
        conn = daoService.getDatabaseConnections();
    }

    public List<Order> getAllOrders() {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * from \"Bootcoding\".order");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                double totalprice = resultSet.getDouble("totalprice");
                String deliveryAddress = resultSet.getString("deliveryaddress");
                long customerId = resultSet.getLong("customerid");
                long vendorId = resultSet.getLong("vendorid");



                Order order = new Order();
                order.setTotalPrice(totalprice);
                order.setDeliveryAddress(deliveryAddress);
                order.setCustomerId(customerId);
                order.setVendorId(vendorId);
                orders.add(order);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return orders;
    }

    public void createTable(){

        StringBuilder queryBuilder = new StringBuilder() ;
        queryBuilder.append("CREATE TABLE ");
        queryBuilder.append(TABLE_NAME);
        queryBuilder.append(" ( ");
        queryBuilder.append("id bigint NOT NULL, ");
        queryBuilder.append("customerid bigint, ");
        queryBuilder.append("vendorid bigint, ");
        queryBuilder.append(" totalprice numeric, ");
        queryBuilder.append("deliveryaddress character varying, ");
        queryBuilder.append("orderstatus character varying, ");
        queryBuilder.append("order_date timestamp without time zone");
        queryBuilder.append(" ); ");
        System.out.println(queryBuilder.toString());
        try{
            Statement statement = conn.createStatement();
            statement.executeUpdate(queryBuilder.toString());

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void insertOrder(Order order){
        try {
            PreparedStatement stmt = conn.prepareStatement("insert into " + TABLE_NAME +" values(?,?,?,?,?,?,?)");
            stmt.setLong(1, order.getId());
            stmt.setLong(2,order.getCustomerId());
            stmt.setLong(3,order.getVendorId());
            stmt.setDouble(4,order.getTotalPrice());
            stmt.setString(5, order.getDeliveryAddress());
            stmt.setString(6,order.getStatus().name());
            stmt.setTimestamp(7, new Timestamp(order.getOrderDate().getTime()));

            stmt.executeUpdate();


        }catch(Exception e){
            throw new RuntimeException(e);
        }

    }


}