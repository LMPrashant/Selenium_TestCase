package Day3;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003_OHRM_LoginPage2_Pagefactory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		
//		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");   //by using xpath
//		driver.findElement(By.name("password")).sendKeys("admin123");
//		driver.findElement(By.xpath("//button[@type='submit']")).submit();
	
		TC004_ORHM_POM2_PageFactory obj = PageFactory.initElements(driver, TC004_ORHM_POM2_PageFactory.class);
		obj.enteruname("Admin");
		obj.enterpword("admin123");
		obj.clicklogin();
	}

}
