package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_SeleninumTest {

	//public static void main(String[] args) throws InterruptedException {
	@Test	
	public void run() throws Exception {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("Automation Testing Tools");
		search.submit();
		System.out.println(driver.getTitle());
		
		driver.navigate().to("https://www.amazon.com/");
		System.out.println(driver.getTitle());
		driver.navigate().back();
		System.out.println("AFter Backward: "+driver.getTitle());
		System.out.println("AFter Backward: "+driver.getCurrentUrl());
		
		driver.navigate().forward();
		System.out.println("AFter Forward: "+driver.getTitle());
		System.out.println("AFter Forward: "+driver.getCurrentUrl());
		
		Thread.sleep(5000);
		driver.quit();

	}

}
