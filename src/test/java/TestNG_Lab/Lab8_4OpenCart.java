package TestNG_Lab;

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

import LABs.LAB11_Lab4_OpenCart_POM;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab8_4OpenCart {
	WebDriver driver; 
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) throws Exception {
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
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
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
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
