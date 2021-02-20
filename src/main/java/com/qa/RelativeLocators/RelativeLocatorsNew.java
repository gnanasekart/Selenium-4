package com.qa.RelativeLocators;

import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocatorsNew {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver d = new ChromeDriver();
		
		d.get("http://leaftaps.com/opentaps/control/main");
		
	//	WebElement ele = d.findElement(withTagName("input").toLeftOf(By.xpath("//label[text()='Password']")));
		//System.out.println(ele.getAttribute("id"));

		try {
			WebElement ele1 = d.findElement(withTagName("input").toRightOf(By.xpath("//label[text()='Username']")));
			System.out.println(ele1.getAttribute("id"));
			
//			WebElement ele2 = d.findElement(withTagName("p").below(By.xpath("//label[text()='Username']")));
//			System.out.println(ele2.getAttribute("class"));
//			
//			WebElement ele3 = d.findElement(withTagName("label").toLeftOf(By.xpath("//input[@id='password']")));
//			System.out.println(ele3.getAttribute("for"));
//			
//			WebElement ele4 = d.findElement(withTagName("label").below(By.xpath("//input[@id='password']")));
//			System.out.println(ele4.getAttribute("for"));
			
			
		} catch (NoSuchElementException e) {			
			e.printStackTrace();
		}
		d.close();
	}
}