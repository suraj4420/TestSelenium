package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class Assignment4 {
	WebDriver driver;

  @Test
  public void Toolsqa() {
	 WebElement name= driver.findElement(By.name("firstname"));
	 name.sendKeys("Suraj");
	String value=name.getAttribute("value");
	System.out.println(value);
	 WebElement Lastname=  driver.findElement(By.name("lastname"));
	 Lastname.sendKeys("Nagdaone");
	 String value1=Lastname.getAttribute("value");
		System.out.println(value1);
	 
	  WebElement Radiosexbutton = driver.findElement(By.name("sex"));
	  if (!Radiosexbutton.isSelected())
		  Radiosexbutton.click();
	  	  
	  driver.findElement(By.xpath("//input[@value='Male']")).click();
	  driver.findElement(By.xpath("//input[@value='2']")).click();
	  driver.findElement(By.id("datepicker")).sendKeys("06/03/2019");
	  driver.findElement(By.xpath("//input[@value='Manual Tester']")).click();
	  driver.findElement(By.xpath("//input[@value='Selenium Webdriver']")).click();
	  
	  WebElement Continents=driver.findElement(By.id("continents"));
	  Select select =new Select(Continents);
	  select.selectByVisibleText("Europe");
	  
	   WebElement SeleniumCommands = driver.findElement(By.id("selenium_commands"));
	  Select Commands = new Select(SeleniumCommands);
	  Commands.selectByVisibleText("Navigation Commands");
	  Commands.selectByVisibleText("WebElement Commands");
	  driver.findElement(By.id("submit")).click();
	  String pessoa = driver.findElement(By.id("NextedText")).getText();               
	  System.out.println(pessoa );
	  
  }
  @BeforeMethod
  	  public void beforeMethod() {
		  System.setProperty("webdriver.chrome.driver","test\\resources\\chromedriver.exe");
			 driver=new ChromeDriver();
			 driver.manage().window().maximize();
			driver.get("http://toolsqa.com/automation-practice-form/");
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
  }

}
