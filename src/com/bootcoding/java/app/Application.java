package com.bootcoding.java.app;

import com.bootcoding.java.model.Customer;
import com.bootcoding.java.service.OrderService;

public class Application {

    public static void main(String[] args) {
        Customer Khushboo = new Customer();  //customer object
        Khushboo.setName("Khushboo Jain");
        Khushboo.setCity("Nagpur");
        Khushboo.setDeliveryAddress("Nagpur, Maharashtra");
        Khushboo.setEmailId("kjain3437@gmail.com");
        Khushboo.print();
        Customer Vishakha = new Customer();
        Vishakha.setName("Vishakha Jain");
        Vishakha.setCity("Akola");
        Vishakha.setDeliveryAddress("Akola, Maharashtra");
        Vishakha.setEmailId("vishakhaj320@gmail.com");
        Vishakha.print();
        Customer Himesh = new Customer();
        Himesh.setName("Himesh Jain");
        Himesh.setCity("Aspur");
        Himesh.setDeliveryAddress("Aspur, Maharashtra");
        Himesh.setEmailId("himeshj320@gmail.com");
        Himesh.print();

        OrderService orderService = new OrderService();
        orderService.createOrder();   //createOrder method called

    }
}
