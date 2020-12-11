package com.qa.Selenium4Methods;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.layertree.LayerTree;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DevToolsPageLoader 
{
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver d = new ChromeDriver();
		
		DevTools devTools = d.getDevTools();
		devTools.createSession();
		
		d.get("https://css-loader.raphaelfabeni.com/");
		d.manage().window().maximize();
		
		//For enabling methods
		devTools.send(LayerTree.enable());
		d.findElementById("loader-default-half").click();
		
		//for adding listeners
		devTools.addListener(LayerTree.layerTreeDidChange(), handler -> {
			System.out.println(handler);
		});
		
		//devTools.clearListeners();
		//once the particular listener work is done then we can close the listener
	}
}
