package Base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.config.Configuration;

public class TestBase {

	public static RemoteWebDriver driver;
	public Configuration config;
	public static RemoteWebDriver getDriver() {
		return driver;
	}

	@BeforeMethod
	public void setUP() {
		config = new Configuration();
		if (config.getBrowserName().equalsIgnoreCase("Chrome")) {
			System.out.println("Launching Chrome Brower");
			driver = new ChromeDriver();
		} else if (config.getBrowserName().equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			System.out.println("Launching Chrome Edge");
		} else {
			System.out.println("Invalid Browser");
		}
		driver.get(config.getAppUrl("flipkart"));
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
