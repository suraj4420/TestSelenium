package Stage4PO;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;
import org.openqa.selenium.support.ui.LoadableComponent;

public class ComposePO extends LoadableComponent<ComposePO>{
	
	@FindBy (xpath="//a[@data-test-id='compose-button']")
	  private WebElement Compose;
	@FindBy (id="message-to-field")
	  private WebElement To;
	
	@FindBy (xpath="//input[@data-test-id='compose-subject']")
	  private WebElement Subject;
	

	@FindBy (xpath="//div[@data-test-id=\"rte\"]")
	  private WebElement Text;
	
/*
	@FindBy (xpath="//span[text()='Send']")
	  private WebElement Sendbutton;*/
	private WebDriver driver;
	private String expectedTitle="Yahoo";

	public ComposePO(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		isLoaded();
}
    public void Sendmail(String to,String subject,String text) {
    	Compose.click();
    	To.sendKeys(to);
    	Subject.sendKeys(subject);
    	Text.sendKeys(text);
      }
	
	
	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		assertEquals(driver.getTitle(),expectedTitle);
		
	}

}
