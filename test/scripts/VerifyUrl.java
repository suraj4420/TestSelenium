package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class VerifyUrl {
	WebDriver driver;
  @Test
  public void VerifyTitle() {
	  	  driver.findElement(By.xpath("//button['Start']")).click();
	  String ActualValue=driver.findElement(By.id("finish")).getText();
		String ExpectedValue="Hello World!";
		assertEquals(ActualValue,ExpectedValue);
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver","test\\resources\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
  }

}
