package LABs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab5_OpenCart_Register {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Prashant");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Karajagi");
		driver.findElement(By.name("email")).sendKeys("pkara@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Prash123");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='input-newsletter-no']")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		System.out.println("You are successfully Registered.");
		Thread.sleep(2000);
		driver.quit();
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://demo.opencart.com/");
//		driver.findElement(By.linkText("My Account")).click();
//		driver.findElement(By.linkText("Register")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.name("firstname")).sendKeys("Gita");
//		driver.findElement(By.name("lastname")).sendKeys("Dalvi");
//		driver.findElement(By.id("input-email")).sendKeys("chiu24@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("abcd1234");
//		Thread.sleep(4000);
//		driver.findElement(By.xpath("//input[@id='input-newsletter-no']")).click();
//		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
//		driver.findElement(By.xpath("//button[@type='submit']")).submit();
//		System.out.println("You are successfully Registered.");
//		Thread.sleep(2000);
//		driver.quit();
		
	}

}
