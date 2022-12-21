package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	By userName = By.name("username");
	By pass = By.name("password");
	By saveBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
	By copyright = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[3]/div[2]/p[1]");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String checkCopyRight() {
		return driver.findElement(copyright).getText();
	}
	
	public void setUserName(String strUserName) {
		driver.findElement(userName).sendKeys(strUserName);
	}
	
	public void setPassword(String strPass) {
		driver.findElement(pass).sendKeys(strPass);
	}
	
	public void clickLogin() {
		driver.findElement(saveBtn).click();
	}
	
	public void loginToOrangeHrm(String strName, String strUserPass) {
		this.setUserName(strName);
		
		this.setPassword(strUserPass);
		
		this.clickLogin();
	}
	
	
}
