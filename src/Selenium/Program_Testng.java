package Selenium;

import org.testng.annotations.Test;

public class Program_Testng {
 @Test(priority = 1,invocationCount=5)
  public void poonam() {
	  System.out.println("Poonam is executing");
  }
  @Test(priority = 2)
  public void pooja() {
	  System.out.println("Pooja1 is executing");
	  //Assert.assertEquals("Shilpa", "shilpa");
	  System.out.println("Pooja2 is executing");
  }
  @Test(priority = 1, dependsOnMethods={"pooja"},alwaysRun=true)
  public void shilpa() {
	  System.out.println("Shilpa is executing");
  }
  
}
