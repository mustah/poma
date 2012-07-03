package com.kirkk.test;

import java.math.BigDecimal;
import java.util.Iterator;

import com.kirkk.bill.Bill;
import com.kirkk.bill.DiscountCalculator;
import com.kirkk.cust.Customer;
import junit.framework.TestCase;

public class PaymentTest extends TestCase {

  public PaymentTest(String arg0) {
    super(arg0);
  }

  public static void main(String[] args) {
  }

  protected void setUp() throws Exception {

  }

  public void testPayment() {

    Customer customer = new Customer();
    customer.createBill(new BigDecimal(500));

    Iterator bills = customer.getBills().iterator();

    while (bills.hasNext()) {
      Bill bill = (Bill) bills.next();
      BigDecimal paidAmount = bill.pay();
      assertEquals("Paid amount not correct.", new BigDecimal(485).setScale(2), paidAmount);
    }
  }

  public void testPaymentWithoutCustomer() {
    Bill bill = new Bill(new DiscountCalculator() {
      public BigDecimal getDiscountAmount() { return new BigDecimal(0.1); }
    }, new BigDecimal(500));

    BigDecimal paidAmount = bill.pay();
    assertEquals("Paid amount not correct.", new BigDecimal(450).setScale(2), paidAmount);
  }

}
