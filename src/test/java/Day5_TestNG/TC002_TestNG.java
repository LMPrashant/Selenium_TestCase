package Day5_TestNG;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_TestNG {
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void f(String username, String password) throws Exception {
	  System.out.println("this is the Test");
	  
	 
		
		Thread.sleep(3000);
		//driver.findElement(By.name("username")).sendKeys("Admin");         //byusing name
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);   //by using xpath
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		boolean dashboard = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]")).isDisplayed();
		System.out.println("Dashboard"+dashboard);
		assertEquals(dashboard, true);
		
		
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("This before Method");
	  WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("This after Method");
	  driver.quit();
  }
  


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "Admin", "admin123" },
      new Object[] { "Admin", "admin12" },
    };
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("after class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("before Test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After Test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("before suite class");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("After suite class");
  }

}
