package Day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003_FindElements {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		Thread.sleep(5000);
		List<WebElement> li = driver.findElements(By.xpath("//input[@class='form-control']"));
		System.out.println(li.size());
		
		for(int i=0;i<li.size();i++) {
			System.out.println(li.get(i).getAttribute("name"));
			System.out.println(li.get(i).getAttribute("id"));
		}
		
	}

}
