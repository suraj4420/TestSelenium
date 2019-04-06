package webDriverDay5.grid;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
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
	  //driver.get("http://selenium-examples.nichethyself.com/");
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
			System.out.println("login test failed"//);*/
		assertEquals(ActualResult,ExpectedResult);
  }
  
	  @Parameters({ "platform", "browser", "version", "url" })
		@BeforeTest(alwaysRun = true)
		public void setup(@Optional("Windows") String platform,
				@Optional("Firefox") String browser, @Optional("1") String version,
				@Optional("http://selenium-examples.nichethyself.com/") String url){

			DesiredCapabilities caps = new DesiredCapabilities();

			/*
			 * Set the Right Platforms based on value in "platform" variable received
			 * from TestNG configuration file
			 */
			switch (platform.toLowerCase()) {
			case "windows":
				caps.setPlatform(Platform.WINDOWS);
				break;
			case "mac":
				caps.setPlatform(Platform.MAC);
				break;
			case "linux":
				caps.setPlatform(Platform.LINUX);
				break;
			case "android":
				caps.setPlatform(Platform.ANDROID);
				break;
			case "unix":
				caps.setPlatform(Platform.UNIX);
				break;
			default:
				caps.setPlatform(Platform.WINDOWS);
				break;
			}

			
			/* Set the Right browser based on value in "browser" and "version" variable received
			 * from TestNG configuration file */		 
			switch (browser.toLowerCase()) {
			case "firefox":
				caps = DesiredCapabilities.firefox();
				break;
			case "internet explorer":
				caps = DesiredCapabilities.internetExplorer();
				break;
			case "safari":
				caps = DesiredCapabilities.safari();
				break;
			case "opera":
				caps = DesiredCapabilities.operaBlink();
				break;
			case "chrome":
				caps = DesiredCapabilities.chrome();
				break;
			case "android":
				caps = DesiredCapabilities.android();
				break;
			default:
				caps = DesiredCapabilities.firefox();
				break;
			}

			/*
			 * The version setting in DesiredCapabilities is disabled. If you want
			 * to execute your tests in a specific browser version then uncomment
			 * the below code.
			 */

			 //caps.setVersion(version);

			/*
			 * Make sure you change the hub address below as per your grid and
			 * network setup to run your tests
			 */
			try {
				driver = new RemoteWebDriver(
						new URL("http://192.168.0.111:4444/wd/hub"), caps);
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
