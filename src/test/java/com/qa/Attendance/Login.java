package com.qa.Attendance;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();

		//		ChromeOptions option = new ChromeOptions();
		//		option.addArguments("headless");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://hcm.myadrenalin.com/adrenalin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		driver.findElement(By.id("txtID")).sendKeys("861");
		driver.findElement(By.id("txtPwd")).sendKeys("10x@Psk");
		driver.findElement(By.id("txtCompName")).sendKeys("amxxx");
		driver.findElement(By.id("lblLogin")).click();
		Thread.sleep(5000);

		if(driver.getTitle().equals("ZOLOG"))
		{
			WebElement loggedin = driver.findElement(By.id("imgYourLogo"));
			boolean displayed = loggedin.isDisplayed();
			Assert.assertTrue(displayed);
			driver.findElement(By.xpath("//div[@class='arrow-down']")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("lnkSignOut")).click();
			driver.switchTo().alert().accept();
			Thread.sleep(1000);
			Assert.assertTrue(driver.getTitle().equals("Exit Adrenalin"));
			
		}else if(! driver.getTitle().equals("ZOLOG"))
		{
			WebElement loginfirsttime = driver.findElement(By.xpath("//span[contains(text(),'Attendance Sign In')]"));
			Assert.assertTrue(loginfirsttime.getText().contains("Attendance"));
			driver.findElement(By.xpath("//input[@name='btnOK']")).click();
			
			WebElement loggedin = driver.findElement(By.id("imgYourLogo"));
			boolean displayed = loggedin.isDisplayed();
			Assert.assertTrue(displayed);
			
			driver.findElement(By.xpath("//div[@class='arrow-down']")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("spExit")).click();
			Thread.sleep(1000);
			Assert.assertTrue(driver.getTitle().equals("Exit Adrenalin"));
		}
		else
		{
			driver.findElement(By.xpath("//div[@class='arrow-down']")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("spExit")).click();
			Thread.sleep(1000);
			Assert.assertTrue(driver.getTitle().equals("Exit Adrenalin"));
		}
		//driver.quit();
	}
}
