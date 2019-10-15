package demo;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ActionsDemo {
	
	 WebDriver driver;
  @Test
  public void f() {
	  
	  System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		  
		  WebElement about = driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[3]/a/span"));
		  Actions act = new Actions(driver);
		 
		  
		  WebDriverWait wait =new WebDriverWait(driver,50);
		  act.moveToElement(about).click().build().perform();
		 
		  WebElement office = driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[3]/ul/li/a/span"));
		  wait.until(ExpectedConditions.elementToBeClickable(office));
		  act.moveToElement(office).click().build().perform();
		  
		  WebElement chennai = driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[3]/ul/li/ul/li[1]/a/span"));
		  wait.until(ExpectedConditions.elementToBeClickable(chennai));
		  act.moveToElement(chennai).click().build().perform();
		  
		  String pwindow = driver.getWindowHandle();
		  Set<String> whandle = driver.getWindowHandles();
		  
		  for(String s:whandle ) {
			  driver.switchTo().window(s);
		  }
		 
		  driver.switchTo().frame(driver.findElement(By.name("main_page")));
		  
		 String text = driver.findElement(By.tagName("address")).getText();
		 System.out.println(text);
		 driver.quit();
		  
		  
		  
		  
		  
		  
		  
  }
}
