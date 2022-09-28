package com.qa.RelativeLocators;

import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocatorsNew {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
	//	WebElement ele = driver.findElement(with(By.tagName("input")).toLeftOf(By.xpath("//label[text()='Password']")));
		//System.out.println(ele.getAttribute("id"));

		try {
			WebElement ele1 = driver.findElement(with(By.tagName("input")).toRightOf(By.xpath("//label[text()='Username']")));
			System.out.println(ele1.getAttribute("id"));
			
//			WebElement ele2 = driver.findElement(with(By.tagName("p")).below(By.xpath("//label[text()='Username']")));
//			System.out.println(ele2.getAttribute("class"));
//			
//			WebElement ele3 = driver.findElement(with(By.tagName("label")).toLeftOf(By.xpath("//input[@id='password']")));
//			System.out.println(ele3.getAttribute("for"));
//			
//			WebElement ele4 = driver.findElement(with(By.tagName("label")).below(By.xpath("//input[@id='password']")));
//			System.out.println(ele4.getAttribute("for"));
			
			
		} catch (NoSuchElementException e) {			
			e.printStackTrace();
		}
		//driver.close();
	}
}