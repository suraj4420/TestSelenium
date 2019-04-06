package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class TriphoboAssign {
  @Test
  public class Triphobo {
		WebDriver driver;
	  @Test
	  public void Trip() throws InterruptedException {
		  driver.findElement(By.xpath("//button[@class='btn btn-default later-btn mod-btn']")).click();
		
		  
		  Actions builder = new Actions(driver);
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  WebElement Triptext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("spl-autocomplete-search")));
		  Triptext.sendKeys("paris");
		  driver.findElement(By.xpath("//div[@id='js-suggestions']/ul/li[3]")).click();
		  driver.findElement(By.id("plan-my-trip")).click();
		  driver.findElement(By.xpath("//button[text()='Save & Let me Plan']")).click();
		  driver.findElement(By.id("js_close_hotel_combine")).click();
		  driver.findElement(By.id("hotel_step_popup_skip_hotel")).click();
	/*	  WebElement Activity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add Activity']")));
		  Activity.click();*/ //use invisibility of wait
		  Thread.sleep(5000);
		   driver.findElement(By.xpath("//button[text()='Add Activity']")).click();
		   WebElement Add = driver.findElement(By.xpath("//li[@id='51ff930de705458d58000002']/div/div[1]/img"));
		   builder.moveToElement(Add);
		  builder.click(Add).perform();
		  WebElement pluseclick   = driver.findElement(By.xpath("//a[@title='Click To Add']"));
		  builder.click(pluseclick).perform();
		   driver.findElement(By.xpath("//label[text()='Day 2']")).click();
		   driver.findElement(By.xpath("//div[@class='global-drawer-overlay']/following::a[@id='close']")).click();
		   Thread.sleep(5000);
		   //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='global-side-drawer']/a[1]"))).click();
		   driver.findElement(By.xpath("//div[@class='global-side-drawer']/a[1]")).click();
		   Thread.sleep(5000);
		   //driver.findElement(By.xpath("//li[@id='51ff930de705458d58000002']/div/div[3]")).click();
		   Actions dragAndDrop= new Actions(driver); 
		 WebElement source=driver.findElement(By.xpath("//li[@id='51ff930de705458d58000002']/div/div[3]"));
		 WebElement target = driver.findElement(By.xpath("//div[@class='end-of-day-wrapper traveling-nextday']"));
		   dragAndDrop.clickAndHold(source).moveToElement(target).release(target).build().perform();;
	   
		 
		 //builder.dragAndDrop(source, target).build().perform();
		 
	  }
	  @BeforeClass
	  public void beforeClass() {
		  System.setProperty("webdriver.chrome.driver","test\\resources\\chromedriver.exe");
			 driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://www.triphobo.com/");
		  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	  }

	  @AfterClass
	  public void afterClass() {
	  }

  }
}
