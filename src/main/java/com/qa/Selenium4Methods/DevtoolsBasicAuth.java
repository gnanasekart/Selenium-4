package com.qa.Selenium4Methods;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.network.Network;
import org.openqa.selenium.devtools.network.model.Headers;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DevtoolsBasicAuth {

	public static void main(String[] args) {

		String name = "admin";
		String password = "admin";
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions option = new ChromeOptions();
		option.setHeadless(true);
		
		ChromeDriver d = new ChromeDriver(option);
		d.get("https://google.co.in");
		
		DevTools devTools = d.getDevTools();
		devTools.createSession();
		
		//Base64 encryption
		String auth = name +":"+ password;
		String encode = Base64.getEncoder().encodeToString(auth.getBytes());
		
		devTools.send(Network.enable(Optional.of(100000), Optional.of(100000), Optional.of(100000)));
		
		Map<String, Object> header = new HashMap<>();
		header.put("Authorization", "Basic " +encode);
		
		devTools.send(Network.setExtraHTTPHeaders(new Headers(header)));
		d.get("https://the-internet.herokuapp.com/basic_auth");
		
		System.out.println(d.getTitle());
		devTools.send(Network.disable());
	}
}
