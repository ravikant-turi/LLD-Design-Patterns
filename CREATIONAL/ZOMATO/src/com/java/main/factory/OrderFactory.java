package com.java.main.factory;

import java.util.List;

import com.java.main.model.User;
import com.java.main.model.Cart;
import com.java.main.model.MenuItem;
import com.java.main.model.Order;
import com.java.main.model.Restaurant;
import com.java.main.strategy.PaymentStrategy;



public interface OrderFactory {
    Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> menuItems,
                      PaymentStrategy paymentStrategy, double totalCost, String orderType);
}