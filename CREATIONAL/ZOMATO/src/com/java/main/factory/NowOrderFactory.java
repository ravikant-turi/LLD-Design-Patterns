package com.java.main.factory;

import java.util.List;

import com.java.main.model.Cart;
import com.java.main.model.DeliveryOrder;
import com.java.main.model.MenuItem;
import com.java.main.model.Order;
import com.java.main.model.PickupOrder;
import com.java.main.model.Restaurant;
import com.java.main.model.User;
import com.java.main.strategy.PaymentStrategy;
import com.java.main.utils.TimeUtils;


public class NowOrderFactory implements OrderFactory {
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
        order.setScheduled(TimeUtils.getCurrentTime());
        order.setTotal(totalCost);
        return order;
    }
}