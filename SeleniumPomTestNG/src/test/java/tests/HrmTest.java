package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.DashboardPage;
import pages.LoginPage;

public class HrmTest {
	WebDriver driver;
	
	@BeforeClass
	public void startBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("========Beowser Started========");
	}
	
	@Test(priority = 0)
	public void startAPp() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String currentURL = driver.getCurrentUrl();
		Assert.assertTrue(currentURL.contains("auth/login"));
		
		System.out.println("Application Loaded Successfully");
	}
	
	@Test(priority = 1)
	public void login() throws InterruptedException {
		LoginPage objLogin = new LoginPage(driver);
		String copyRightCheck = objLogin.checkCopyRight();
		Assert.assertTrue(copyRightCheck.equals("OrangeHRM OS 5.2"), "Copy Right Miss Match");
		objLogin.loginToOrangeHrm("Ädmin", "admin123");
		System.out.println("Login To OrangeHRM Successfully");
		Thread.sleep(5000);
	}
	
	@Test(priority = 2)
	public void logout() throws InterruptedException {
		DashboardPage objDash = new DashboardPage(driver);
		String checkHeadingDash = objDash.checkHeading();
		Assert.assertTrue(checkHeadingDash.equals("Dashboard"), "Dashboard Heading Miss Match");
		objDash.userLogout();
		System.out.println("Logout From OrangeHRM Successfully");
		Thread.sleep(3000);
	}
	
	
	@AfterClass
	public void closeApp() {
		driver.quit();
		System.out.println("======Browser Closed======");
	}

}
