package com.extensiblejava.customer;

import java.math.BigDecimal;

import com.extensiblejava.order.Order;

public interface Customer {

  public String getName();

  public Order[] getOrders();

  public Order createNewOrder(Integer productQuantity, BigDecimal chargeAmount);
}