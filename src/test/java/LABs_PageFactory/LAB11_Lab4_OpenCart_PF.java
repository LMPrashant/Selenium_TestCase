package LABs_PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LAB11_Lab4_OpenCart_PF {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		LAB11_Lab4_OpenCart_POM_PF obj = PageFactory.initElements(driver, LAB11_Lab4_OpenCart_POM_PF.class);
		obj.desktops();
		
		obj.selectsort(1);
		
		obj.search();
		obj.keywords("Mobile");
		obj.markable();
		Thread.sleep(2000);
		obj.searchbtn();
	}

}
