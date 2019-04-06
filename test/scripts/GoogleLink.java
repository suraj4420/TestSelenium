package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class GoogleLink {
	WebDriver driver;
  @Test
  public void AllGoogleLink() {
	  List<WebElement> AllGoogleLinks =driver.findElements(By.tagName("a"));
	  for(WebElement oneElement: AllGoogleLinks) {
		  System.out.println(oneElement.getText()+"-"+oneElement.getAttribute("href"));
			  
	  }
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver","test\\resources\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("https://Google.com");
	    driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
  }

}
