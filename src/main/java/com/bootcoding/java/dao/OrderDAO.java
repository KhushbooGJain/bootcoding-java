package com.bootcoding.java.dao;

import com.bootcoding.java.model.Order;
import com.bootcoding.java.model.OrderStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private Connection conn;

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
}