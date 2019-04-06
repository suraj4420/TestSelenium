package grid;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class MyFirstTestNGTest {
	RemoteWebDriver driver;
	
@Test
	public void GoogleSearch() {
		driver.get("http://google.com/");
		driver.findElement(By.name("q")).sendKeys("job search");
		driver.findElement(By.name("btnK")).click();
		//Thread.sleep(5000);
		
	}
  @Test
  public void SeleniumExample() {
	  driver.get("http://selenium-examples.nichethyself.com/");
		WebElement username=driver.findElement(By.id("loginname"));
		username.sendKeys("stc123");
		driver.findElement(By.id("loginpassword")).sendKeys("12345");
		driver.findElement(By.id("loginbutton")).click();
		
		String ExpectedResult="My account";
		String ActualResult=driver.getTitle();
		/*
		if(ExpectedResult.equals(ActualResult))
			System.out.println("login test passed");
		else
			System.out.println("login test failed");*/
		assertEquals(ActualResult,ExpectedResult);
  }
  @BeforeClass
  public void BeforClass(){
	    /*//System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-64bit.exe");
			System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
			//driver =new FirefoxDriver();
			driver =new ChromeDriver();*/
   DesiredCapabilities	capabilities=new DesiredCapabilities();
   capabilities.setBrowserName("firefox");
   
   try {
	driver=new RemoteWebDriver(new URL("http://192.168.0.120:4444/wd/hub"),capabilities);
} catch (MalformedURLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	  
			driver.manage().window().maximize();	  
  }
  @BeforeMethod
  public void beforeMethod() {
	
  }

  @AfterMethod
  public void afterMethod() {
	 //driver.quit();
  }
@AfterClass
public void afterclass() {
	//driver.quit();
	
	
}
}
