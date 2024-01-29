package LABs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LAB11_Lab4_OpenCart_POM {

	WebDriver driver;
	By deskp = By.linkText("Desktops");
	By mac = By.linkText("Mac (1)");
	By sort = By.id("input-sort");
	By search = By.xpath("//*[@id=\"search\"]/button");
	By key = By.id("input-search");
	By mark = By.id("input-description");
	By click = By.id("button-search");
	
	public LAB11_Lab4_OpenCart_POM(WebDriver driver2) {
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
	
	public void search() {
		driver.findElement(search).click();
	}
	public void keywords(String item) {
		driver.findElement(key).sendKeys(item);
	}
	public void markable() {
		driver.findElement(mark).click();
	}
	public void searchbtn() {
		driver.findElement(click).click();
	}
}
