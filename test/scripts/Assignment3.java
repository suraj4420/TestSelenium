package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Assignment3 {
	WebDriver driver;
  @Test
  public void flipKarLink() {
	  List<WebElement> AllflipKarLink =driver.findElements(By.tagName("a"));
	  for(WebElement oneElement: AllflipKarLink) {
	 System.out.println(oneElement.getText()+"-"+oneElement.getAttribute("href"));
  }
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver","test\\resources\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		driver.get("https://flipkart.com");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
  }

  @AfterMethod
  public void afterMethod() {
  }

}
