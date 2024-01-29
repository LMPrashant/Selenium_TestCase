package PropertiesLab;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab12_DemoCart_Props {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		InputStream input1 = new FileInputStream("D:\\Training\\Eclipse\\Jan2024_SeleniumClass\\src\\test\\java\\PropertiesLab\\Opencart.properties");
		Properties prop = new Properties();
		prop.load(input1);
		String url = prop.getProperty("url");
		String prdt = prop.getProperty("product");
		String prdt2 = prop.getProperty("product2");
		System.out.println("The URL is: "+ url);
		System.out.println("The product is: "+ prdt);
		System.out.println("The product is: "+ prdt2);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		LAB12_DemoCart_Pom obj = new LAB12_DemoCart_Pom(driver);
		obj.desktop();
		obj.mac();
		obj.sort(1);
		obj.search();
		obj.search2(prdt);
		obj.tick();
		obj.searchbutton();
		driver.navigate().back();
		obj.clear2();
		obj.search2(prdt2);
		obj.searchbutton();
		driver.quit();
	}

}
