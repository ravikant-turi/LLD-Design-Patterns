package com.java.main.factory;

import java.util.List;

import com.java.main.model.User;
import com.java.main.model.Cart;
import com.java.main.model.DeliveryOrder;
import com.java.main.model.MenuItem;
import com.java.main.model.Order;
import com.java.main.model.PickupOrder;
import com.java.main.model.Restaurant;
import com.java.main.strategy.PaymentStrategy;


public class ScheduledOrderFactory implements OrderFactory {
    private String scheduleTime;

    public ScheduledOrderFactory(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    @Override
    public Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> menuItems,
                             PaymentStrategy paymentStrategy, double totalCost, String orderType) {
        Order order = null;

        if (orderType.equals("Delivery")) {
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setUserAddress(user.getAddress());
            order = deliveryOrder;
        } else {
            PickupOrder pickupOrder = new PickupOrder();
            pickupOrder.setRestaurantAddress(restaurant.getLocation());
            order = pickupOrder;
        }

        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setItems(menuItems);
        order.setPaymentStrategy(paymentStrategy);
        order.setScheduled(scheduleTime);
        order.setTotal(totalCost);
        return order;
    }

	
}