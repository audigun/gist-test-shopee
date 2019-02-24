package connectionWithCrhome;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class connection {
	
	public WebDriver driver;
	String url ="https://github.com/";

  @BeforeMethod
  public void beforeMethod() {
	  driver = new ChromeDriver();
	  driver.get(url);
	  driver.manage().window().fullscreen();
  }

  @AfterMethod
  public void afterMethod() {
//	  driver.close();
  }

}
