package com.extensiblejava.customer.test;

import java.math.BigDecimal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.extensiblejava.customer.Customer;
import com.extensiblejava.customer.CustomerManager;
import com.extensiblejava.order.Order;
import junit.framework.TestCase;

//Note the removal of the com.extensiblejava.customer.impl package import.

public class CustomerTest extends TestCase {

  private ApplicationContext ctx;

  public static void main(String[] args) {
    String[] testCaseName = {CustomerTest.class.getName()};

    junit.textui.TestRunner.main(testCaseName);
  }

  protected void setUp() {
    this.ctx = new ClassPathXmlApplicationContext("classpath*:com/extensiblejava/customer/test/customer.xml");
  }

  public void testCustomerLoad() throws Exception {
    //CustomerBuilder builder = new DefaultCustomerBuilder();
    //Customer customer = builder.build();
    CustomerManager customerManager = (CustomerManager) this.ctx.getBean("customerManager");
    Customer customer = customerManager.getCustomer();
    assertEquals("John Doe", customer.getName());
  }

  public void testCustomerOrderLoad() throws Exception {
    //CustomerBuilder builder = new DefaultCustomerBuilder();
    //Customer customer = builder.build();
    CustomerManager customerManager = (CustomerManager) this.ctx.getBean("customerManager");
    Customer customer = customerManager.getCustomer();
    Order[] orders = customer.getOrders();
    assertEquals(orders.length, 3);
  }

  public void testPlaceOrder() {
    //CustomerBuilder builder = new DefaultCustomerBuilder();
    //Customer customer = builder.build();
    CustomerManager customerManager = (CustomerManager) this.ctx.getBean("customerManager");
    Customer customer = customerManager.getCustomer();
    Order order = customer.createNewOrder(new Integer(3), new BigDecimal("50.00"));
    //order.setDiscountAmount(new BigDecimal("0.50")); //No longer allowed.
    assertEquals(order.getDiscountAmount(), new BigDecimal("0.25"));
  }
}
