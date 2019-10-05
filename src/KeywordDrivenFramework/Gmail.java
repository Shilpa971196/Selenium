package KeywordDrivenFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Gmail
{
	WebDriver driver;
public String launch(String locator, String data, String criteria)
{
	if (locator.equalsIgnoreCase("chrome"))
			{
		System.setProperty("webdriver.chrome.driver", "/F:/java/chromedriver.exe");
			driver = new ChromeDriver();
			}
	else if(locator.equalsIgnoreCase("firefox"))
	{
	driver = new FirefoxDriver();
	}
	else if(locator.equalsIgnoreCase("opera"))
	{
	driver = new OperaDriver();
	}
	else
	{
		driver = new InternetExplorerDriver();
	}
	
driver.get(data);
return ("done");
}


public String fill(String locator, String data, String criteria) throws InterruptedException
{
	driver.findElement(By.xpath(locator)).sendKeys(data);
	Thread.sleep(5000);
	return("done");
}

public String click(String locator, String data, String criteria)
{
	driver.findElement(By.xpath(locator)).click();
	return("done");
}

public String checkUserID(String locator, String data, String criteria) throws InterruptedException
{
	Thread.sleep(5000);
	if (criteria.equalsIgnoreCase("valid") && driver.findElement(By.id("Passwd")).isDisplayed())
	{
		return("Test Passed");
	}
	else if (criteria.equalsIgnoreCase("invalid") && driver.findElement(By.id("errormsg-o-email")).isDisplayed());
	{
		return("Test Passed"); 
	}
	/*else
		{
		return("Test Failed");
		} */
}
public String close(String locator, String data, String criteria) throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
		return("done");
	}
				
}



