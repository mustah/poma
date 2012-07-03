package com.extensiblejava.calculator.impl;

import java.math.BigDecimal;

import com.extensiblejava.calculator.DiscountCalculator;
import com.extensiblejava.order.Order;

public class DefaultCalculator implements DiscountCalculator {

  public BigDecimal calculateDiscount(Order[] orders) {
    int totalQuantity = 0;
    for (int i = 0; i < orders.length; i++) {
      totalQuantity += orders[i].getProductQuantity().intValue();
    }
    if (totalQuantity < 10) {
      return new BigDecimal("0.05");
    } else if ((totalQuantity >= 10) && (totalQuantity < 100)) {
      return new BigDecimal("0.10");
    } else if (totalQuantity >= 100) {
      return new BigDecimal("0.25");
    }
    return new BigDecimal("0.00");
  }
}