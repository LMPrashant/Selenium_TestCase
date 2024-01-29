package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TC002_ORHM_POM {

	WebDriver driver;
	
	By uname = By.name("username");
	By pword = By.name("password");
	By loginbtn = By.xpath("//button[@type='submit']");
	By dashboard = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]");
	
	public TC002_ORHM_POM(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver=driver2;
	}

	public boolean verifyusername()
	{
		boolean isusername_displayed=driver.findElement(uname).isDisplayed();
		return isusername_displayed;
	}
	public boolean verifypassword()
	{
		boolean ispassword_displayed=driver.findElement(pword).isDisplayed();
		return ispassword_displayed;
	}
	public void enteruname(String username) {
		driver.findElement(uname).sendKeys(username);
	}
	
	public void enterpword(String password) {
		driver.findElement(pword).sendKeys(password);
	}
	
	public void clicklogin() {
		driver.findElement(loginbtn).click();
	}
	
	public boolean verifylogin()
	{boolean isdashboard_displayed;
		try
		{
		 isdashboard_displayed=driver.findElement(dashboard).isDisplayed();
		}
		catch(Exception e)
		{
			isdashboard_displayed=false;
		}
		
		return isdashboard_displayed;
	}

	
	
}
