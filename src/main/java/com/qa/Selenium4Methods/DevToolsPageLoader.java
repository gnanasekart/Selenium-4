package com.qa.Selenium4Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.layertree.LayerTree;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DevToolsPageLoader 
{
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		driver.get("https://css-loader.raphaelfabeni.com/");
		driver.manage().window().maximize();
		
		//For enabling methods
		devTools.send(LayerTree.enable());
		driver.findElement(By.id("loader-default-half")).click();
		
		//for adding listeners
		devTools.addListener(LayerTree.layerTreeDidChange(), handler -> {
			System.out.println(handler);
		});
		
		//devTools.clearListeners();
		//once the particular listener work is done then we can close the listener
	}
}
