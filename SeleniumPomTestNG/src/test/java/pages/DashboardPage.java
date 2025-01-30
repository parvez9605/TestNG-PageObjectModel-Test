package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	WebDriver driver;
	
	By heading = By.className("oxd-topbar-header-breadcrumb-module");
	By authName = By.className("oxd-userdropdown-name");
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String checkHeading() {
		return driver.findElement(heading).getText();
	}
	
	public void userLogout() throws InterruptedException {
		driver.findElement(authName).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}
}
