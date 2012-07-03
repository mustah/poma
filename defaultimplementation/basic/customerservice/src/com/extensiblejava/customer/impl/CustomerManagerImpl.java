package com.extensiblejava.customer.impl;

import com.extensiblejava.customer.Customer;
import com.extensiblejava.customer.CustomerBuilder;
import com.extensiblejava.customer.CustomerManager;

public class CustomerManagerImpl implements CustomerManager {

  private CustomerBuilder customerBuilder;

  public CustomerManagerImpl(CustomerBuilder customerBuilder) {
    this.customerBuilder = customerBuilder;
  }

  public Customer getCustomer() {
    return customerBuilder.build();
  }
}