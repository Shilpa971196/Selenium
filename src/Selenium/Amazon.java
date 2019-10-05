package Selenium;

import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver","/F:/java/chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.navigate().to("https://www.amazon.in");
Thread.sleep(2000);
driver.navigate().to("https://www.flipkart.com/");
driver.navigate().back();
Thread.sleep(2000);
driver.manage().window().maximize();
//driver.findElement(By.xpath("//*[@class='a-row a-spacing-top-micro']/div/div/input")).sendKeys("110009");
//driver.findElement(By.xpath("//*[@class='a-column a-span4 a-span-last']/span/span/span")).click();
//driver.findElement(By.xpath("//*[@class='a-popover-footer']/span/span/input")).click();
WebElement e = driver.findElement(By.xpath("//*[contains(text(),'Account & Lists')]"));
Actions a = new Actions(driver);
a.moveToElement(e).click().build().perform();
//driver.findElement(By.xpath("//*[@id='nav-flyout-ya-signin']/a/span")).click();
///driver.switchTo().frame("a-popover-wrapper");
driver.findElement(By.xpath("//*[@class='a-row a-spacing-base']/input")).sendKeys("yadavsy971196@gmail.com",Keys.TAB,Keys.ENTER);
//driver.findElement(By.id("continue")).click();
driver.findElement(By.id("ap_password")).sendKeys("shilpa@123");
driver.findElement(By.id("signInSubmit")).submit(); //(//*[class='nav-line-2'])[2]
// Mouse hover 
WebElement c= driver.findElement(By.xpath("//*[@id='nav-shop']/a/span/span "));
a.moveToElement(c).build().perform();
WebElement m = driver.findElement(By.xpath("(//*[text()=\"Men's Fashion\"])[1]"));
a.moveToElement(m).build().perform();
WebElement n = driver.findElement(By.xpath("(//*[text() ='Shirts'])[1]"));
a.moveToElement(n).click().build().perform();
Thread.sleep(2000);
List<WebElement> l = driver.findElements(By.xpath("//*[@class='a-carousel']/li"));
Thread.sleep(2000);
//System.out.println(l.size());
l.get(0).click();
Thread.sleep(2000);
l.get(1).click();
Thread.sleep(2000);
l.get(2).click();
Thread.sleep(2000);	

// Switch to main window
ArrayList<String> s = new ArrayList<String>(driver.getWindowHandles());
System.out.println("Windows Opened are :" + s);
driver.switchTo().window(s.get(0));
driver.navigate().to("https://www.flipkart.com/");
Thread.sleep(2000);
 int f =driver.manage().getCookies().size();
System.out.println("Number of Cookies before deletion : "+ f);
 driver.manage().deleteAllCookies();
 int g = driver.manage().getCookies().size();
 System.out.println("Number of Cookies After deletion : "+ g);
 
 Dimension d = new Dimension (800,600);
	driver.manage().window().setSize(d);
	Thread.sleep(2000);
Point p = new Point(650,0);	
driver.manage().window().setPosition(p);
File f1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
File f2 = new File("F:\\java\\Screenshot\\S1.png");
FileUtils.copyFile(f1, f2);

driver.navigate().back();
driver.manage().window().maximize();
driver.switchTo().window(s.get(2));
WebElement i1 = driver.findElement(By.xpath("(//*[@id='a-autoid-6'])[2]"));

a.moveToElement(i1).click().build().perform();
WebElement i2 = driver.findElement(By.xpath("(//*[@id='landingImage'])"));
a.doubleClick(i2).build().perform();
Thread.sleep(2000);

driver.findElement(By.xpath("//*[@class='a-icon a-icon-close']")).click();
Thread.sleep(2000);
//Go to Accounts&List and SignOut
WebElement i3 = driver.findElement(By.xpath("//*[@class='nav-line-2'][text()='Account & Lists']"));
a.moveToElement(i3).build().perform();
Thread.sleep(2000);
WebElement i4 = driver.findElement(By.xpath("//*[text()='Sign Out']"));
a.moveToElement(i4).click().build().perform();
driver.quit();	
	}

}
