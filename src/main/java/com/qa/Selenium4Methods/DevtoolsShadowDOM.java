package com.qa.Selenium4Methods;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.dom.DOM;
import org.openqa.selenium.devtools.dom.model.Node;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DevtoolsShadowDOM {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver d = new ChromeDriver();

		DevTools devTools = d.getDevTools();
		devTools.createSession();
		
		d.get("https://embed.plnkr.co/fVIYs97WzjwjYnuDE75u/");
		d.manage().window().maximize();
		
		devTools.send(DOM.enable());

		//here we using getFlattenedDocument method to get all the node id from the DOM and
		//Boolean enabled to get frame and shadow root element also 
		List<Node> ele = devTools.send(DOM.getFlattenedDocument(Optional.of(-1), Optional.of(Boolean.TRUE)));

		for(Node element : ele)
		{
			if(element.getNodeName().equals("H1"))
			{
				System.out.println(element.getAttributes());
			}
		}
	}
}