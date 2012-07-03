package com.extensiblejava.calculator;

import java.math.BigDecimal;

import com.extensiblejava.order.Order;

public interface DiscountCalculator {

  public BigDecimal calculateDiscount(Order[] orders);

}