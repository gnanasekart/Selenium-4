package com.qa.Selenium4Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.SessionId;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DebugExistingBrowser {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	
	ChromeOptions option = new ChromeOptions();
	option.setExperimentalOption("debuggerAddress", "localhost:54754");
	ChromeDriver d = new ChromeDriver(option);
	
	//d.get("http://leaftaps.com/opentaps/control/main");
	d.manage().window().maximize();
	
	/*Capabilities capabilities = d.getCapabilities();
	for(String cap : capabilities.getCapabilityNames())
	{
		System.out.println(cap);
		System.out.println("---------------");
		System.out.println(capabilities.getCapability(cap));
	}
	*/
	
	d.findElement(By.id("username")).sendKeys("demosalesmanager");
	SessionId session = d.getSessionId();
	System.out.println("session id is = "+session);
	}
	//89e2380a3e36c3464b5dd1302349b1382549290d
	

}
