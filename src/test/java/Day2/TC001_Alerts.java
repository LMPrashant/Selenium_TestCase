package Day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_Alerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://letcode.in/alert");
//		driver.findElement(By.id("accept")).click();
//		Thread.sleep(3000);
//		Alert simplealert = driver.switchTo().alert();
//		System.out.println(simplealert.getText());
//		simplealert.accept();
//		
//		driver.findElement(By.id("confirm")).click();
//		Thread.sleep(2000);
//		Alert confirmAlert = driver.switchTo().alert();
//		System.out.println(confirmAlert.getText());
//		confirmAlert.accept();
		

		driver.findElement(By.id("prompt")).click();
		//Thread.sleep(2000);
		Alert promptalert = driver.switchTo().alert();
		System.out.println(promptalert.getText());
		//Thread.sleep(2000);
		promptalert.sendKeys("Prashant");
		promptalert.accept();
		driver.quit();
	}

}
