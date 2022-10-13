package com.bootcoding.java.app;

import com.bootcoding.java.dao.CustomerDAO;
import com.bootcoding.java.dao.DAOService;
import com.bootcoding.java.dao.OrderDAO;
import com.bootcoding.java.model.Customer;
import com.bootcoding.java.model.Order;
import com.bootcoding.java.model.OrderStatus;
import com.bootcoding.java.service.CustomerService;
import com.bootcoding.java.service.OrderService;
import com.bootcoding.java.service.VendorService;
import com.bootcoding.java.utils.PasswordGenerator;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class Application {

    public static void main(String[] args) {

        DAOService dbService = new DAOService();
//        dbService.printCustomerData();
        System.out.println("********************************************************");
//        dbService.printVendorData();
        System.out.println("********************************************************");
        OrderDAO orderDAO = new OrderDAO();
//        orderDAO.createTable();
//        List<Order> allOders=orderDAO.getAllOrders();

        // CustomerId = 1001, 1002, 1003
        // VendorId = 2001,2002,2003
        // orderId = 3001, 3002, 3003
//        Random rand = new Random();
//        int min = 200;
//        int max = 2000;
//        for(int i = 1; i <= 100; i++) {
//            Order order = new Order();
//            // order fields set
//            order.setStatus(OrderStatus.NEW);
//            order.setCustomerId(1000 + i);
//            order.setVendorId(2000 + i);
//            order.setId(3000 + i);
//            order.setDeliveryAddress("Nagpur");
//            int randomPrice = rand.nextInt((max - min) + 1) + min;
//            order.setTotalPrice(randomPrice);
//            order.setOrderDate(new Date());
//
//            orderDAO.insertOrder(order);
//        }
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.createTable();

        for(int i = 1; i <= 100; i++) {
            Customer customer = new Customer();
            // order fields set
            customer.setPassword(PasswordGenerator.getRandomPassword());
            customer.setState("Maharashtra");
            customer.setModifiedAt(new Date());
            customer.setDeliveryAddress("Nagpur, Maharashtra");
            customer.setName("Customer " + i );
            customer.setEmailId("Customer" + i + "@gmail.com");
            customer.setId(1000 + i);
            customer.setCreatedAt(new Date());
            customer.setCity("Nagpur");


            customerDAO.insertCustomer(customer);
        }




//
//        Customer Khushboo = new Customer();  //customer object
//        Khushboo.setName("Khushboo Jain");
//        Khushboo.setCity("Nagpur");
//        Khushboo.setDeliveryAddress("Nagpur, Maharashtra");
//        Khushboo.setEmailId("kjain3437@gmail.com");
//        Khushboo.print();
//        Customer Vishakha = new Customer();
//        Vishakha.setName("Vishakha Jain");
//        Vishakha.setCity("Akola");
//        Vishakha.setDeliveryAddress("Akola, Maharashtra");
//        Vishakha.setEmailId("vishakhaj320@gmail.com");
//        Vishakha.print();
//        Customer Himesh = new Customer();
//        Himesh.setName("Himesh Jain");
//        Himesh.setCity("Aspur");
//        Himesh.setDeliveryAddress("Aspur, Maharashtra");
//        Himesh.setEmailId("himeshj320@gmail.com");
//        Himesh.print();
//
//        OrderService orderService = new OrderService();
//        orderService.createOrder();   //createOrder method called
//
//        CustomerService  customerService = new CustomerService();
//        customerService.registerCustomer();
//
//        VendorService vendorService =new VendorService();
//        vendorService.registerVendor();


    }
}
