package cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import connectionWithCrhome.connection;

public class testCases extends connection{
	
  @Test
  public void createNewGist() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		// Login GitHub
		// i could use log4j for this but it may takes times, so i used hardcode instead, and credentials could be configured here below
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/a[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login_field\"]"))).sendKeys("");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"password\"]"))).sendKeys("");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login\"]/form/div[3]/input[3]"))).click();
		
		// Go To Gist Page
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"user-links\"]/li[2]/details/summary"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"user-links\"]/li[2]/details/details-menu/a[3]"))).click();
		
		// New Gist
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"user-links\"]/li[1]/a"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"gists\"]/input"))).sendKeys("testing");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"gists\"]/div[2]/div/div[1]/div[1]/input[2]"))).sendKeys("testing gist.txt");
		WebElement body = driver.findElement(By.xpath("//*[@id=\"gists\"]/div[2]/div/div[2]/div/div[5]/div[1]/div/div/div/div[5]/div/pre"));
		Actions action = new Actions(driver);
		action.moveToElement(body);
		action.click();
		action.sendKeys("this is for testing purposes");
		action.build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"new_gist\"]/div/div[2]/button[1]"))).click();
		
		// Edit Existing Gist
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"gist-pjax-container\"]/div[1]/div/div[1]/ul/li[1]/a"))).click();
		WebElement editBody = driver.findElement(By.xpath("//*[@id=\"gists\"]/div[2]/div/div[2]/div/div[5]/div[1]/div/div/div/div[5]/div/pre"));
		Actions editAction = new Actions(driver);
		editAction.moveToElement(editBody);
		editAction.click();
		editAction.sendKeys("\n" + "no its not for testing only, but for creating new body");
		editAction.build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("contains(#edit_gist_94824088) > div > div.form-actions > button"))).click();
		
		// Delete Existing Gist
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@type=\"gist-pjax-container\"]/div[1]/div/div[1]/ul/li[2]/form/button"))).click();
    	driver.switchTo().alert().accept();
    	
    	// See all list of Gist
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div/div/div/ul/li[1]/a"))).click();
  }
}
