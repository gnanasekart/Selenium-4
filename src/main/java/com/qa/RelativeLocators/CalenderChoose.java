package com.qa.RelativeLocators;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderChoose {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver d = new ChromeDriver();
		d.get("https://jqueryui.com/datepicker/");
		d.manage().window().maximize();
		
		d.switchTo().frame(0);
		
		String expdate = "10/10/2021";
		d.findElementByXPath("//input[@id='datepicker']").click();
		/*
		String[] splitdate = expdate.split("/");
		int date = Integer.parseInt(splitdate[1]);
		int month = Integer.parseInt(splitdate[0]);
		int year = Integer.parseInt(splitdate[2]);
		
		Calendar cal = new GregorianCalendar();
		int actmonth = cal.get(Calendar.MONTH)+1;
		//this is normal index value for month so it start from 0 as jan so we mention jan - 0+1
		int actyear = cal.get(Calendar.YEAR);
		
		//need to confirm we checking for future month
		int yeardiff = year - actyear;
		int monthdiff = month - actmonth;
		int clicks = 0;
		
		if(yeardiff > 0) {
			clicks = (yeardiff * 12) + monthdiff;
		}else if(yeardiff == 0 && monthdiff > 0)
		{
			clicks = monthdiff;
		}else if(yeardiff < 0) {
			System.out.println("negative");
		}
		
		d.findElementByXPath("//input[@id='datepicker']").click();
			
		WebElement prev = d.findElementByXPath("//span[text()='Prev']");
		
		for(int i = 0; i< clicks; i++)
		{
			d.findElementByXPath("//span[text()='Next']").click();
			Thread.sleep(500);
		}
		d.findElementByLinkText(""+date).click();
	
	*/
		JavascriptExecutor js  = (JavascriptExecutor)d;
		js.executeScript("$('#datepicker').datepicker(\"setDate\", '10/10/2022')");
	}
}