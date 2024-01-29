package LABs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LAB6_OpenCart {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("email")).sendKeys("pkara@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Prash123");
		driver.findElement(By.tagName("button")).click();
		
		WebElement ele = driver.findElement(By.linkText("Components"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.linkText("Monitors (2)")).click();
		
		Select s1 = new Select(driver.findElement(By.id("input-limit")));
		s1.selectByIndex(1);
		
		//driver.findElement(By.linkText("Apple Cinema 30")).click();
		driver.findElement(By.xpath("//*[@id=\"product-list\"]/div[1]/form/div/div[2]/div[1]/h4/a")).click();
		driver.findElement(By.id("input-option-value-6")).click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(2000);
		driver.findElement(By.id("input-option-value-9")).click();
		Select s2 = new Select (driver.findElement(By.id("input-option-217")));
		s2.selectByIndex(2);
		
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.id("input-option-209")).sendKeys("Hello World");
		//driver.findElement(By.id("button-cart")).submit();
		
		driver.findElement(By.id("button-upload-222")).sendKeys("C:\\Users\\prashant.karajagi\\Downloads\\24190_PF_form11.pdf");
		
		//driver.findElement(By.id("button-cart")).click();
		
	}

}
