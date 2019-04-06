package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class GmailLogin {
	WebDriver driver;
  @Test
  public void Gmail() {
	 /* driver.findElement(By.xpath("//input[@type="email"]")).sendKeys("suraj.nagdaone@Gmail.com");
	  driver.findElement(By.xpath("//span[text()='Next']")).click();
	   driver.findElement(By.xpath("//input[@type='password']")).sendKeys("advik@123");
	  driver.findElement(By.xpath("//button[@id='login-signin']")).click();*/
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver","test\\resources\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("https://accounts.google.com/AccountChooser?service=mail&continue=https://mail.google.com/mail/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
  /*dummyaccount8418
  dummacc123*/

  @AfterClass
  public void afterClass() {
  }

}
