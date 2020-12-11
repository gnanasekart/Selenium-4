package CompactabilityTesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.windows.WindowsDriver;

public class NotepadAutomation {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability("app", "c:\\Windows\\System32\\notepad.exe");
		dc.setCapability("platformName", "Windows");
		dc.setCapability("deviceName", "AMX-RL-19-255-W");
		
		WindowsDriver wd = new WindowsDriver(new URL("http://127.0.0.1:4723/"), dc);
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//from webdriver lib
		wd.findElement(By.name("File")).click();

		//from Applium lib
		wd.findElementByAccessibilityId("3").click();
		wd.findElementByAccessibilityId("FileNameControlHost").sendKeys("sekar.txt");
		wd.findElementByAccessibilityId("1").click();
	}
}
