package com.bootcoding.java.model;

import java.util.List;

public class Order {
    private long id;
    private long CustomerId;
    private long VendorId;
    private double TotalPrice;
    private String deliveryAddress;
    private OrderStatus status;
    private List<MenuItem> menuItems;
}
