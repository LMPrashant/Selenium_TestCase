package TestNG_Lab;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
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

import LABs.LAB11_Lab3_OpenCart_POM;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LAB8_3OpenCartPOMmain {
	WebDriver driver;
	  @Test(dataProvider = "dp")
	  public void f(Integer n, String s) throws Exception {
		 
		    
			driver.manage().window().maximize();        // to maximize the window
			Thread.sleep(2000);
			LAB11_Lab3_OpenCart_POM obj = new LAB11_Lab3_OpenCart_POM(driver);
			obj.desktops();
			
			obj.selectsort(1);
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,500)");
			
			obj.addcart();
			
			}
		
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("This is before method");
		  WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			driver.get("https://demo.opencart.com/");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("This is after method");
		  //driver.quit();
	  }


	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { 1, "a" },
	      new Object[] { 2, "b" },
	    };
	  }
	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("This is before class");
	  }

	  @AfterClass
	  public void afterClass() {
		  System.out.println("This is after class");
	  }

	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("This is before test");
	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("This is after test");
	  }

	  @BeforeSuite
	  public void beforeSuite() {
		  System.out.println("This is before suite ");
	  }

	  @AfterSuite
	  public void afterSuite() {
	  }

}
