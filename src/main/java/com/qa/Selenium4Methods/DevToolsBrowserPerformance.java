package com.qa.Selenium4Methods;

import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.performance.Performance;
import org.openqa.selenium.devtools.performance.model.Metric;

import com.google.common.collect.ImmutableMap;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DevToolsBrowserPerformance {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver d = new ChromeDriver();
		
		DevTools devTools = d.getDevTools();
		devTools.createSession();
		
		// we need to enable the performance domain with timeDomain otherwise we can custome based on our need
		//devTools.send(Performance.enable(timeDomain));
		//timeDomain is removed from customize
		
		devTools.send(enable());
		
		d.get("http://google.co.in");
		d.manage().window().maximize();
		
		//Retrieve current values of run-time metrics.
		List<Metric> metrics = devTools.send(Performance.getMetrics());
		for(Metric met : metrics)
		{
			System.out.println(met.getName()+" - "+met.getValue());
			System.out.println();
		}
	}
	
	//customized code
	public static Command<Void> enable() 
	{
        ImmutableMap.Builder<String, Object> params = ImmutableMap.builder();
        return new Command<>("Performance.enable", params.build());
        
        //Apache kafca
    }
}
