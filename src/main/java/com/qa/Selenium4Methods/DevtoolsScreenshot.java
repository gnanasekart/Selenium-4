package com.qa.Selenium4Methods;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.dom.model.Rect;
import org.openqa.selenium.devtools.page.Page;
import org.openqa.selenium.devtools.page.Page.CaptureScreenshotFormat;
import org.openqa.selenium.devtools.page.Page.GetLayoutMetricsResponse;
import org.openqa.selenium.devtools.page.model.Viewport;

import com.google.common.collect.ImmutableMap;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DevtoolsScreenshot {

	public static void main(String[] args) 
	{

		WebDriverManager.chromedriver().setup();
		ChromeDriver d = new ChromeDriver();
		d.get("https://chromedevtools.github.io/devtools-protocol/");
		d.manage().window().maximize();

		DevTools devTools = d.getDevTools();
		devTools.createSession();

		//capture screenshot using page class 
		//enable the page class
		devTools.send(Page.enable());

		//used to get the layout of the page
		//GetLayoutMetricsResponse class will return the visualviewport, contentsize,. layoutviewport 
		GetLayoutMetricsResponse layout = devTools.send(Page.getLayoutMetrics());

		//get the content layout size by using Rectangle class it will return x, y, width height
		Rect content = layout.getContentSize();
		int height = ((Long)content.getHeight()).intValue();
		int width = ((Long)content.getWidth()).intValue();
		System.out.println(height+"  "+width);

		//setDeviceMetricsOverride method from page class is depricated we customize below and pass the values
		devTools.send(setDeviceMetricsOverride(width, height, 1.0, false));

		//using the captureScreenshot method from page to capture the screen shot and it return the Base 64 output 
		Viewport clip = new Viewport(0d, 0d, width, height, 1d);

		String send = devTools.send(Page.captureScreenshot(Optional.of(CaptureScreenshotFormat.PNG), 
				Optional.of(100), Optional.of(clip), Optional.of(Boolean.TRUE)));

		System.out.println(send);
	}

	public static Command<Void> setDeviceMetricsOverride(java.lang.Integer width, java.lang.Integer height, java.lang.Number deviceScaleFactor, java.lang.Boolean mobile) 
	{
		java.util.Objects.requireNonNull(width, "width is required");
		java.util.Objects.requireNonNull(height, "height is required");
		java.util.Objects.requireNonNull(deviceScaleFactor, "deviceScaleFactor is required");
		java.util.Objects.requireNonNull(mobile, "mobile is required");
		ImmutableMap.Builder<String, Object> params = ImmutableMap.builder();
		params.put("width", width);
		params.put("height", height);
		params.put("deviceScaleFactor", deviceScaleFactor);
		params.put("mobile", mobile);
		return new Command<>("Page.setDeviceMetricsOverride", params.build());
	}
}