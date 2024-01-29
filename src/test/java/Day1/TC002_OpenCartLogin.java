package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_OpenCartLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		System.out.println("My account is present: "+driver.findElement(By.linkText("My Account")).isDisplayed());
		System.out.println("My account Text is: "+driver.findElement(By.linkText("My Account")).getText());
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("abc@gmail.com");
		
		Actions act = new Actions(driver);
		act.sendKeys("fatima@yahoo.com");
		act.sendKeys(Keys.TAB);
		act.sendKeys("welcome");
		act.sendKeys(Keys.TAB);
		act.sendKeys(Keys.TAB);
		act.sendKeys(Keys.ENTER);
		
		act.perform();
		
		//driver.findElement(By.id("input-password")).sendKeys("abc123");
		//driver.findElement(By.xpath("//button[@type='submit']")).submit();
		
	}

}
