package com.qa.Selenium4Methods;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.dom.DOM;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DevToolsDOMListener {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver d = new ChromeDriver();
		
		DevTools devTools = d.getDevTools();
		devTools.createSession();
		
		d.get("http://google.co.in");
		
		devTools.send(DOM.enable());
		devTools.addListener(DOM.documentUpdated(), handler -> {
			System.out.println(handler);
		});
		Thread.sleep(20000);
	}
}
