package com.bootcoding.java.dao;

import com.bootcoding.java.model.Customer;
import com.bootcoding.java.model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerDAO
{
    private Connection conn;
    private static final String TABLE_NAME = "Customer_table";

    public CustomerDAO()
    {
        DAOService daoService = new DAOService();
        conn = daoService.getDatabaseConnections();
    }

    public List<Customer> getAllCustomers()
    {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * from \"Bootcoding\".customer");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                String name = resultSet.getString("name");
                String emailId = resultSet.getString("emailId");
                String password = resultSet.getString("password");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String deliveryAddress = resultSet.getString("deliveryAddress");
                Date createdAt = new Date(resultSet.getLong("createdAt"));
                Date modifiedAt = new Date(resultSet.getLong("modifiedAt"));

                Customer customer = new Customer();
                customer.setName(name);
                customer.setEmailId(emailId);
                customer.setPassword(password);
                customer.setCity(city);
                customer.setState(state);
                customer.setDeliveryAddress(deliveryAddress);

                customers.add(customer);


            }

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return customers ;
    }
    public void createTable(){
        StringBuilder queryBuilder = new StringBuilder() ;
        queryBuilder.append("CREATE TABLE ");
        queryBuilder.append(TABLE_NAME);
        queryBuilder.append(" ( ");
        queryBuilder.append("id bigint NOT NULL, ");
        queryBuilder.append(" name character varying, ");
        queryBuilder.append("city character varying, ");
        queryBuilder.append(" state character varying,");
        queryBuilder.append(" emailid character varying, ");
        queryBuilder.append("  password character varying,");
        queryBuilder.append(" deliveryaddress character varying, ");
        queryBuilder.append("createdat timestamp without time zone, ");
        queryBuilder.append(" modifiedat timestamp without time zone ");
        queryBuilder.append(" ); ");
        System.out.println(queryBuilder.toString());
        try{
            Statement statement = conn.createStatement();
            statement.executeUpdate(queryBuilder.toString());

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void insertCustomer(Customer customer){
        try {
            PreparedStatement stmt = conn.prepareStatement("insert into " + TABLE_NAME +" values(?,?,?,?,?,?,?,?,?)");
            stmt.setLong(1, customer.getId());
            stmt.setString(2,customer.getName());
            stmt.setString(3,customer.getCity());
            stmt.setString(4,customer.getState());
            stmt.setString(5,customer.getEmailId());
            stmt.setString(6, customer.getPassword());
            stmt.setString(7,customer.getDeliveryAddress());
            stmt.setTimestamp(8, new Timestamp(customer.getCreatedAt().getTime()));
            stmt.setTimestamp(9, new Timestamp(customer.getModifiedAt().getTime()));

            stmt.executeUpdate();


        }catch(Exception e){
            throw new RuntimeException(e);
        }


    }

}
