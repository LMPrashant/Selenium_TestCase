package LABs_PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LAB11_Lab4_OpenCart_POM_PF {

	WebDriver driver;
	@FindBy(linkText="Desktops")
	WebElement deskp;
	@FindBy(linkText="Mac (1)")
	WebElement mac;
	@FindBy(id="input-sort")
	WebElement srt;
	@FindBy(xpath="//*[@id=\"search\"]/button")
	WebElement search;
	@FindBy(id="input-search")
	WebElement key;
	@FindBy(id="input-description")
	WebElement mark;
	@FindBy(id="button-search")
	WebElement click;
	
	public LAB11_Lab4_OpenCart_POM_PF(WebDriver driver2) {
		this.driver=driver2;
		// TODO Auto-generated constructor stub
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
	
	public void search() {
		search.click();
	}
	public void keywords(String item) {
		key.sendKeys(item);
	}
	public void markable() {
		mark.click();
	}
	public void searchbtn() {
		click.click();
	}
}
