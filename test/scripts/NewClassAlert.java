package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class NewClassAlert {
	WebDriver driver;
  @Test
  public void AlertTest() {
	  Alert myAlert= driver.switchTo().alert();
	  myAlert.accept();
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver","test\\resources\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		driver.get("https://timesofindia.indiatimes.com/");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
	  
  }

}
