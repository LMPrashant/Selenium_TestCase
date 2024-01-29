package LABs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LAB11_Lab4_OpenCart {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		LAB11_Lab4_OpenCart_POM obj = new LAB11_Lab4_OpenCart_POM(driver);
		obj.desktops();
		
		obj.selectsort(1);
		
		obj.search();
		obj.keywords("Mobile");
		obj.markable();
		Thread.sleep(2000);
		obj.searchbtn();
	}

}
