package CompactabilityTesting;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SarceLabLaunchGrid {

	private static RemoteWebDriver d;
	public static void main(String[] args) throws MalformedURLException {
	
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setPlatform(Platform.WIN10);
		cap.setBrowserName("chrome");
		cap.setVersion("85.0");
		
		d = new RemoteWebDriver(new URL(""), cap);
		
		d.get("http://leaftaps.com/opentaps/");
		d.manage().window().maximize();
		
		d.findElementById("username").sendKeys("demosalesmanager");
		d.findElementById("password").sendKeys("crmsfa");

		d.findElementByClassName("decorativeSubmit").click();
		
		d.findElementByLinkText("CRM/SFA").click();
		
		d.findElementByLinkText("Create Lead").click();
		
		d.findElementById("createLeadForm_companyName").sendKeys("all");
		d.findElementById("createLeadForm_firstName").sendKeys("gnana");
		d.findElementById("createLeadForm_lastName").sendKeys("sekar");
		d.findElementByName("firstNameLocal").sendKeys("gnanasekar");
		d.findElementByName("lastNameLocal").sendKeys("T");
		d.findElementByName("personalTitle").sendKeys("MR");
		d.findElementByXPath("//input[@class='smallSubmit']").click();
		d.close();
	}
}