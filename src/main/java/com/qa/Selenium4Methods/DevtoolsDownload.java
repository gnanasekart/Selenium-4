package com.qa.Selenium4Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.page.Page;
import org.openqa.selenium.devtools.page.Page.SetDownloadBehaviorBehavior;

import com.google.common.collect.ImmutableMap;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DevtoolsDownload {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		//download file using SetDownloadBehaviorBehavior method in Page class, 
		//we had modified this method based on our need
		devTools.send(setDownloadBehavior(SetDownloadBehaviorBehavior.ALLOW, "D:\\study\\selenium\\naveen\\Selenium 4\\TL\\Week 3"));

		driver.get("https://the-internet.herokuapp.com/download");
		driver.findElement(By.xpath("//a[@href='download/Space.jpg']")).click();
	}

	public static Command<Void> setDownloadBehavior(SetDownloadBehaviorBehavior behavior, java.lang.String downloadPath) 
	{
		java.util.Objects.requireNonNull(behavior, "behavior is required");
		ImmutableMap.Builder<String, Object> params = ImmutableMap.builder();
		params.put("behavior", behavior);
		params.put("downloadPath", downloadPath);
		return new Command<>("Page.setDownloadBehavior", params.build());
	}
}
