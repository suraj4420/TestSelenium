package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Yahoo {
	WebDriver driver;
	  @Test
	  public void Gmail() {
		 WebElement email= driver.findElement(By.xpath("//input[@id='login-username']"));
		 email.sendKeys("dummyaccount8418");
		 email.sendKeys(Keys.TAB);
		   driver.findElement(By.xpath("//input[@id='login-signin']")).click();
		   driver.findElement(By.xpath("//input[@id='login-passwd']")).sendKeys("dummacc123");
		  driver.findElement(By.xpath("//button[@id='login-signin']")).click();
	  }
	  @BeforeClass
	  public void beforeClass() {
		  System.setProperty("webdriver.chrome.driver","test\\resources\\chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
			 driver=new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.get("https://login.yahoo.com");
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
	  /*dummyaccount8418
	  dummacc123*/

	  @AfterClass
	  public void afterClass() {
	  }

	}

