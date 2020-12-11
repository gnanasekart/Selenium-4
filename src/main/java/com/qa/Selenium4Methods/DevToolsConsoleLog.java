package com.qa.Selenium4Methods;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.log.Log;
import org.openqa.selenium.devtools.log.model.LogEntry.Level;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DevToolsConsoleLog {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver d = new ChromeDriver();
		DevTools devTools = d.getDevTools();
		devTools.createSession();
		
		devTools.send(Log.enable());
		
		devTools.addListener(Log.entryAdded(), handler -> {
			Level level = handler.getLevel();
			String text = handler.getText();
			System.out.println("We go the log at "+level+" level and the console message is "+text);
		});
		
		d.get("http://leafground.com");
		d.manage().window().maximize();
	}
}
