package demo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleDemo {
	  WebDriver driver;
		String ExpectedResult ="selenium - Google Search";
  @Test
  public void f() throws IOException {
	  
	  System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
	driver = new ChromeDriver();
	  driver.get("https://www.google.com");
	  
	  
	  
	  driver.findElement(By.name("q")).sendKeys("selenium");
	  driver.findElement(By.name("q")).submit();
	  WebDriverWait wait = new WebDriverWait(driver,50); 
	  wait.until(ExpectedConditions.titleContains(ExpectedResult));
	  
	  Assert.assertEquals(ExpectedResult, driver.getTitle());
	 // System.out.println(driver.getTitle());
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("alert('Welcome to Accenture!');");
	  driver.switchTo().alert().accept();
			 js.executeScript("return document.title;").toString();
			 
			 TakesScreenshot ts=(TakesScreenshot)driver;
				File sr=ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(sr, new File("./screenshots/contact.png"));
				System.out.println("screenshots taken"); 
			 
			  
  }
}
