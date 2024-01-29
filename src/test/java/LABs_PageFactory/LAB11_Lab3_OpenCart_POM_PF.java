package LABs_PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LAB11_Lab3_OpenCart_POM_PF {

	WebDriver driver;
	@FindBy(linkText="Desktops")
	WebElement deskp;
	

	@FindBy(linkText="Mac (1)")
	WebElement mac;
	
	@FindBy(id="input-sort")
	WebElement srt;
	
	@FindBy(xpath="//*[@id=\"product-list\"]/div/form/div/div[2]/div[2]/button[1]")
	WebElement cart;
		
	public LAB11_Lab3_OpenCart_POM_PF(WebDriver driver) {
		super();
		this.driver = driver;
	}
	

	public void desktops() throws Exception {
		WebElement ele = deskp;
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		Thread.sleep(2000);
		mac.click();
	}
	
	public void selectsort(int i) {
		Select sort = new Select (srt);
		sort.selectByIndex(i);
	}
	
	public void addcart() {
		cart.click();
	
	}
}
