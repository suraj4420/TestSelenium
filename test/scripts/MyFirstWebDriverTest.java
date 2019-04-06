package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyFirstWebDriverTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver;
	    System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-64bit.exe");
		//System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		driver =new FirefoxDriver();
		//driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://selenium-examples.nichethyself.com/");
		WebElement username=driver.findElement(By.id("loginname"));
		username.sendKeys("stc123");
		driver.findElement(By.id("loginpassword")).sendKeys("12345");
		driver.findElement(By.id("loginbutton")).click();
		
		String ExpectedResult="Previous/Ongoing trips";
		String ActualResult=driver.getTitle();
		
		if(ExpectedResult.equals(ActualResult))
			System.out.println("login test passed");
		else
			System.out.println("login test failed");
		
		
	}

}
