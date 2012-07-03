package com.extensiblejava.customer.impl;

import java.math.BigDecimal;

import com.extensiblejava.calculator.DiscountCalculator;
import com.extensiblejava.customer.Customer;
import com.extensiblejava.order.Order;
import com.extensiblejava.order.OrderBuilder;
import com.extensiblejava.order.impl.DefaultOrder;

public class DefaultCustomer implements Customer {

  private String fullName;
  private Order[] orders;
  private OrderBuilder builder;
  private DiscountCalculator calculator;

  public DefaultCustomer(String fullName, OrderBuilder builder, DiscountCalculator discountCalculator) {
    this.fullName = fullName;
    this.builder = builder;
    this.calculator = discountCalculator;
  }

  public String getName() { return this.fullName; }

  public Order[] getOrders() {
    if (this.orders == null) {
      this.orders = builder.build();
    }
    return this.orders;
  }

  public Order createNewOrder(Integer productQuantity, BigDecimal chargeAmount) {
    int numOrders = this.getOrders().length + 1;
    Order[] newOrders = new Order[numOrders];
    System.arraycopy(this.orders, 0, newOrders, 0, this.orders.length);
    DefaultOrder newOrder = new DefaultOrder(productQuantity, chargeAmount);
    newOrders[numOrders - 1] = newOrder;
    this.orders = newOrders;
    BigDecimal discount = this.calculateDiscount();
    newOrder.setDiscountAmount(discount);
    return this.orders[numOrders - 1];
  }

  private BigDecimal calculateDiscount() {
    return this.calculator.calculateDiscount(this.orders);
  }
}