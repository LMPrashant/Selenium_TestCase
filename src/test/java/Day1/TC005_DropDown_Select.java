package Day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC005_DropDown_Select {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Desktops")).click();
		driver.findElement(By.linkText("Mac (1)")).click();
		Select s1 = new Select(driver.findElement(By.id("input-sort")));
		
		
		Select ele = new Select(driver.findElement(By.id("input-sort")));
		List<WebElement> li = s1.getOptions();
		
		for(int i=0;i<li.size();i++) {
			System.out.println(li.get(i).getText());
		}
		//s1.selectByVisibleText("Price (Low>High)");
		s1.selectByIndex(5);	
		
	}

}
