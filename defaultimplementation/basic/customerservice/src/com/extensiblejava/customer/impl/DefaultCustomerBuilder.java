package com.extensiblejava.customer.impl;

import com.extensiblejava.calculator.DiscountCalculator;
import com.extensiblejava.customer.Customer;
import com.extensiblejava.customer.CustomerBuilder;
import com.extensiblejava.order.OrderBuilder;

public class DefaultCustomerBuilder implements CustomerBuilder {

  private OrderBuilder orderBuilder;
  private DiscountCalculator discountCalculator;

  public DefaultCustomerBuilder(OrderBuilder orderBuilder, DiscountCalculator discountCalculator) {
    this.orderBuilder = orderBuilder;
    this.discountCalculator = discountCalculator;
  }

  public Customer build() {
    return new DefaultCustomer("John Doe", orderBuilder, discountCalculator);
  }
}