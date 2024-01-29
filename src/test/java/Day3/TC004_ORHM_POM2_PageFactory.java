package Day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TC004_ORHM_POM2_PageFactory {

	WebDriver driver;
	
	//By uname = By.name("username");
	@FindBy(name="username")
	WebElement uname;
	
	//By pword = By.name("password");
	@FindBy(name="password")
	WebElement pword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginbtn;
	//By loginbtn = By.xpath("//button[@type='submit']");
	
	

	public void enteruname(String username) {
		uname.sendKeys(username);
	}
	
	public void enterpword(String password) {
		pword.sendKeys(password);
	}
	
	public void clicklogin() {
		loginbtn.click();
	}
	
}
