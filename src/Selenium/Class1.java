package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Class1 {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "/F:/java/chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		
		//driver.get("http://newtours.demoaut.com/");
		
		driver. navigate().to("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		String x=driver.getTitle();
		System.out.println(x);
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName")).sendKeys("Shilpa");
		driver.findElement(By.name("lastName")).sendKeys("Kumari");
		driver.findElement(By.name("phone")).sendKeys("7245785963");
		driver.findElement(By.id("userName")).sendKeys("s.yadav@gmail.com");
		driver.findElement(By.name("address1")).sendKeys("abc");
		driver.findElement(By.name("address2")).sendKeys("xyz");
		driver.findElement(By.name("city")).sendKeys("Agra");
		driver.findElement(By.name("state")).sendKeys("U.P");
		driver.findElement(By.name("postalCode")).sendKeys("123456");
		Select sc =new Select(driver.findElement(By.name("country")));
		sc.selectByVisibleText("INDIA");
		driver.findElement(By.id("email")).sendKeys("s.yadav@gmail.com");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("confirmPassword")).sendKeys("123456");
		driver.findElement(By.name("register")).click();
		String y = driver.findElement(By.xpath("//*[@face=\'Arial, Helvetica, sans-serif\'][1]")).getText();
		System.out.println(y);
		driver.quit();		

	}

}
