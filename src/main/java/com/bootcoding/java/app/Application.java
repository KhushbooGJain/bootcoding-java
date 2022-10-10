package com.bootcoding.java.app;

import com.bootcoding.java.dao.DAOService;
import com.bootcoding.java.dao.OrderDAO;
import com.bootcoding.java.model.Customer;
import com.bootcoding.java.model.Order;
import com.bootcoding.java.service.CustomerService;
import com.bootcoding.java.service.OrderService;
import com.bootcoding.java.service.VendorService;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        DAOService dbService = new DAOService();
        dbService.printCustomerData();
        System.out.println("********************************************************");
        dbService.printVendorData();
        System.out.println("********************************************************");
        OrderDAO orderDAO = new OrderDAO();
        List<Order> allOders=orderDAO.getAllOrders();

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
