package LABs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LAB11_Lab3_OpenCart_POM {

	WebDriver driver;
	By deskp = By.linkText("Desktops");
	By mac = By.linkText("Mac (1)");
	By sort = By.id("input-sort");
	By cart = By.xpath("//*[@id=\"product-list\"]/div/form/div/div[2]/div[2]/button[1]");
	
	public LAB11_Lab3_OpenCart_POM(WebDriver driver2) {
		this.driver=driver2;
		// TODO Auto-generated constructor stub
	}

	public void desktops() throws Exception {
		WebElement ele = driver.findElement(deskp);
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		Thread.sleep(2000);
		driver.findElement(mac).click();
	}
	
	public void selectsort(int i) {
		Select sort = new Select (driver.findElement(By.id("input-sort")));
		sort.selectByIndex(i);
	}
	
	public void addcart() {
		driver.findElement(cart).click();
	
	}
}
