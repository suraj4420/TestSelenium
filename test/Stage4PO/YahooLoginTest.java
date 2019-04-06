package Stage4PO;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class YahooLoginTest {
	YahooLoginPo myLogin;
	ComposePO sendMail;
  @Test
  public void YahooLoginTest() {
	  sendMail=myLogin.login("dummyaccount8418","dummacc123"); 
	  myLogin.Textclick();
	  sendMail.Sendmail("suraj.nagdaone@gmail.com","TestMail","Hi suraj /n plz check your testing mail");
	  
	  //assertEquals(myLogin.getTitle(),"My account");
  }
  @BeforeMethod
  public void beforeMethod() {
	  myLogin = new YahooLoginPo();
	  myLogin.get();
  }

  @AfterMethod
  public void afterMethod() {
	  myLogin.close();
  }

}