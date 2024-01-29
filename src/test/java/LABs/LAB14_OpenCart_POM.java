package LABs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LAB14_OpenCart_POM {

	WebDriver driver;
	By fname =By.name("firstname");
	By lname = By.name("lastname");
	By email = By.name("email");
	By pass = By.name("password");
	By rdobtn = By.id("input-newsletter-yes");
	By check = By.xpath("//input[@type='checkbox']");
	By btn = By.xpath("//button[@type='submit']");
	
	public LAB14_OpenCart_POM(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver=driver2;
	}

	public void enterfirstname(String firstname1) {
		driver.findElement(fname).sendKeys(firstname1);
	}
	
	public void enterlastname(String enterlastname1) {
		driver.findElement(lname).sendKeys(enterlastname1);
	}
	
	public void enteremail(String email1) {
		driver.findElement(email).sendKeys(email1);
	}
	
	public void enterpassword(String password1) {
		driver.findElement(pass).sendKeys(password1);
	}

	public void radiobtn() {
		driver.findElement(rdobtn).click();
	}
	public void checkbox() {
		driver.findElement(check).click();
	}
	public void submitbtn() {
		driver.findElement(btn).click();
	}
	
}
