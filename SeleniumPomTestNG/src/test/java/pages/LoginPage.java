package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	By userName = By.name("username");
	By pass = By.name("password");
	By saveBtn = By.className("orangehrm-login-button");

	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	
	public void setUserName(String strUserName) {
		driver.findElement(userName).sendKeys(strUserName);
//		driver.findElement(By.name("username")).sendKeys("Admin");
	}
	
	public void setPassword(String strPass) {
		driver.findElement(pass).sendKeys(strPass);
//		driver.findElement(By.name("password")).sendKeys("admin123");
	}
	
	public void clickLogin() {
		driver.findElement(saveBtn).click();
//		driver.findElement(By.className("orangehrm-login-button")).click();
	}
	
	public void loginToOrangeHrm(String strName, String strUserPass) {
		this.setUserName(strName);
		
		this.setPassword(strUserPass);
		
		this.clickLogin();
	}
	
	
}
