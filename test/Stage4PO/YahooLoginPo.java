package Stage4PO;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class YahooLoginPo extends LoadableComponent<YahooLoginPo> {
	@FindBy (id = "login-username")
	@CacheLookup
	private WebElement username;
	
	@FindBy (id="login-signin")
	private WebElement signinbutton;
	
	@FindBy (id = "login-passwd")
	private WebElement userpass;
	
	@FindBy (id = "login-signin")
	private WebElement loginButton;
	
	@FindBy (xpath = "//b[@id='bottombar-mail-dot']/following::span[1]")
	private WebElement mailclick;
	
	
	
	private WebDriver driver;
	private Object expectedTitle = ("Yahoo - login");
	
	public YahooLoginPo() {
		System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-64bit.exe");
		driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
		
	}
	
	public ComposePO login(String user, String pass) {
		username.clear();
		username.sendKeys(user);
		signinbutton.submit();
		userpass.sendKeys(pass);
		loginButton.click();
		mailclick.click();
	ComposePO compose=new ComposePO(driver);
	return compose;
		
		
	}
	public void Textclick() {
		mailclick.click();
		
	}
	public String getTitle() {
		return driver.getTitle();
	}

	public void close() {
		// TODO Auto-generated method stub
		//driver.quit();
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		driver.get("https://login.yahoo.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		assertEquals(driver.getTitle(),expectedTitle );
		
	}
	
}
