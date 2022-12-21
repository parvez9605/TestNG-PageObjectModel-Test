package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	WebDriver driver;
	
	By heading = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6");
	By authName = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p");
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String checkHeading() {
		return driver.findElement(heading).getText();
	}
	
	public void userLogout() throws InterruptedException {
		driver.findElement(authName).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]")).click();
	}
}
