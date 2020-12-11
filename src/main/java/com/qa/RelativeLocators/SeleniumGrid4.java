package com.qa.RelativeLocators;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.browser.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGrid4 {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("edge");
		
		RemoteWebDriver r = new RemoteWebDriver(new URL("http://localhost:4444/"), dc);
		r.get("http://google.com");
	}

}
