package com.kirkk.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AllTests extends TestCase {

  public AllTests(String name) {
    super(name);
  }

  public static void main(java.lang.String[] args) {
    junit.textui.TestRunner.run(AllTests.suite());
  }

  public static Test suite() {
    TestSuite packageTests = new TestSuite(AllTests.class.getName());
    packageTests.addTestSuite(PaymentTest.class);

    return packageTests;

  }

}