package com.qa.Selenium4Methods;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.ConverterFunctions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.dom.DOM;
import org.openqa.selenium.devtools.dom.model.Node;
import org.openqa.selenium.devtools.dom.model.NodeId;

import com.google.common.collect.ImmutableMap;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DevToolsDOMListenerRootNode {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver d = new ChromeDriver();
		DevTools devTools = d.getDevTools();
		devTools.createSession();
		d.get("http://leaftaps.com/opentaps/control/main");
		
		//enable the DOM
		devTools.send(DOM.enable());
		
		//nowget the rootnode
		Node send = devTools.send(DOM.getDocument(Optional.of(-1), Optional.of(Boolean.TRUE)));
		
		//once after we get the rootnode
		//now we interact with the locator or the element
		NodeId username = devTools.send(querySelector(Integer.parseInt((send.getNodeId().toString())), "#username"));
		System.out.println("nodeid "+username);
		
		//Now we have the nodeid of that particular locator 
		//now we need to get all the attribute of the particluar nodeid
		List<String> allattr = devTools.send(DOM.getAttributes(username));
		allattr.forEach(attr -> System.out.println(attr));
		
		//using listener to find any modification during the element interaction
		devTools.addListener(DOM.attributeModified(), handler -> {
			System.out.println(handler);
		});
				
		Thread.sleep(400000);
	}
	
	public static Command<org.openqa.selenium.devtools.dom.model.NodeId> querySelector(int nodeId, java.lang.String selector) {
        java.util.Objects.requireNonNull(nodeId, "nodeId is required");
        java.util.Objects.requireNonNull(selector, "selector is required");
        ImmutableMap.Builder<String, Object> params = ImmutableMap.builder();
        params.put("nodeId", nodeId);
        params.put("selector", selector);
        return new Command<>("DOM.querySelector", params.build(), ConverterFunctions.map("nodeId", org.openqa.selenium.devtools.dom.model.NodeId.class));
    }
	
	public static Command<java.util.List<java.lang.String>> getAttributes(int nodeId) 
	{
        java.util.Objects.requireNonNull(nodeId, "nodeId is required");
        ImmutableMap.Builder<String, Object> params = ImmutableMap.builder();
        params.put("nodeId", nodeId);
        return new Command<>("DOM.getAttributes", params.build(), ConverterFunctions.map("attributes", new com.google.common.reflect.TypeToken<java.util.List<java.lang.String>>() {
        }.getType()));
    }
}
