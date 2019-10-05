package Selenium;
// Web table handling using xpath
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Class2 {
static double min=3000000;
static double max=0;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
 System.setProperty("webdriver.chrome.driver","/F:/java/chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.navigate().to("https://money.rediff.com/gainers");
driver.manage().window().maximize();
driver.findElement(By.xpath("//*[@class=\"f12\"]")).click();
driver.findElement(By.xpath("(//*[@href=\"//money.rediff.com/gainers/bse/weekly\"])[1]")).click();
List<WebElement> element = driver.findElements(By.xpath("//*[@class=\"dataTable\"]/tbody/tr"));
System.out.println(element.size());
for(int i= 1 ; i<=element.size();i++) {
	Thread.sleep(20);
	
String x= driver.findElement(By.xpath("//*[@class=\"dataTable\"]/tbody/tr["+i+"]/td[4]")).getText();
double y = Double.parseDouble(x.replace(",", ""));
if(min > y) {
min = y;
}
if(max < y)
{
max=y;
}
//System.out.println(y);
}
System.out.println("Minimum value is :" +min);	
System.out.println("Maximum value is : " + max);
driver.quit();
	}

}
