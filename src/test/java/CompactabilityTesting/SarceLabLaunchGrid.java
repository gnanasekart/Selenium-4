package CompactabilityTesting;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SarceLabLaunchGrid {

	private static RemoteWebDriver driver;
	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setPlatform(Platform.WIN10);
		cap.setBrowserName("chrome");
		cap.setVersion("85.0");

		driver = new RemoteWebDriver(new URL(""), cap);

		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();

		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();

		driver.findElement(By.linkText("Create Lead")).click();

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("all");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("gnana");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("sekar");
		driver.findElement(By.name("firstNameLocal")).sendKeys("gnanasekar");
		driver.findElement(By.name("lastNameLocal")).sendKeys("T");
		driver.findElement(By.name("personalTitle")).sendKeys("MR");
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		driver.close();
	}
}