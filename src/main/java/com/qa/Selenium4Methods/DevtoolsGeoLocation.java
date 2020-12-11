package com.qa.Selenium4Methods;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.emulation.Emulation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DevtoolsGeoLocation {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		ChromeOptions option = new ChromeOptions();
		option.setHeadless(false);
		
		ChromeDriver d = new ChromeDriver(option);
	
		DevTools devTools = d.getDevTools();
		devTools.createSession();
		Number a = 40.730610;
		Number b = -73.935242;
		Number c  =1;
		devTools.send(Emulation.setGeolocationOverride(Optional.of(a), Optional.of(b), Optional.of(c)));
		
		d.get("https://oldnavy.gap.com/stores");
	}
}
