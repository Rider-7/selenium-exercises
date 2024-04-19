package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
  
  @Before("@Banking")
  public void bankingSetup() {
    Utilities.printBeforeMessage();
    System.out.println("Setup the entries in Banking database");
  }

  @Before("@Mortgage")
  public void mortgageSetup() {
    Utilities.printBeforeMessage();
    System.out.println("Setup the entries in Mortgage database");
  }

  @After
  public void teardown() {
    System.out.println("Clear the entries");
    Utilities.printAfterMessage();
  }
}
