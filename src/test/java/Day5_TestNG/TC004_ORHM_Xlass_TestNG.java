package Day5_TestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Day3.TC002_ORHM_POM;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class TC004_ORHM_Xlass_TestNG {
	WebDriver driver;
	  @Test(dataProvider = "dp")
	  public void f(String uname, String pwd) throws Exception  {	
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  long timestamp = new Date().getTime();
		  System.out.println("The tiem is: "+timestamp);
		  
		  TC002_ORHM_POM obj = new TC002_ORHM_POM(driver);
		  String title=driver.getTitle();
		 // Assert.assertEquals(title, "OrangeHRM");
		  
		  ExtentReports extent=new ExtentReports();
			ExtentSparkReporter spark=new ExtentSparkReporter(timestamp+"prashant.html");
			extent.attachReporter(spark);
			ExtentTest test=extent.createTest("Verify the Title of OrngeHRM");
			if(title.equals("orangeHRM1"))
			{
				test.pass("OrangeHRM title is displayed");
				
			}
			else
			{
				Thread.sleep(3000);
				File sfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File dfile = new File("D:\\Training\\Eclipse\\Jan2024_SeleniumClass\\p1.png");
				FileUtils.copyFile(sfile, dfile);
				String path = dfile.getAbsolutePath();
				test.fail("OrangeHRM title is not displayed"
						,MediaEntityBuilder
						.createScreenCaptureFromPath(path)
						.build());
				//test.addScreenCaptureFromPath(path);
			}
			if(obj.verifyusername())
			{
				test.pass("OrangeHRM title is displayed");
				
			}
			else
			{
				Thread.sleep(3000);
				File sfile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File dfile1 = new File("D:\\Training\\Eclipse\\Jan2024_SeleniumClass\\userverify.png");
				FileUtils.copyFile(sfile1, dfile1);
				String path1 = dfile1.getAbsolutePath();
				test.fail("Username is not displayed"
						,MediaEntityBuilder
						.createScreenCaptureFromPath(path1)
						.build());
				//test.addScreenCaptureFromPath(path);
			}
			if(obj.verifypassword())
			{
				test.pass("Password is displayed");
				
			}
			else
			{
				Thread.sleep(3000);
				File sfile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File dfile2 = new File("D:\\Training\\Eclipse\\Jan2024_SeleniumClass\\passverify.png");
				FileUtils.copyFile(sfile2, dfile2);
				String path2 = dfile2.getAbsolutePath();
				test.fail("password is not displayed"
						,MediaEntityBuilder
						.createScreenCaptureFromPath(path2)
						.build());
				//test.addScreenCaptureFromPath(path);
			}
		  
			obj.enteruname(uname);
			obj.enterpword(pwd);
			obj.clicklogin();
			if(obj.verifylogin())
			{
				test.pass("Login Successfull");
				
			}
			else
			{
				Thread.sleep(3000);
				File sfile3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File dfile3 = new File("D:\\Training\\Eclipse\\Jan2024_SeleniumClass\\verifylogin.png");
				FileUtils.copyFile(sfile3, dfile3);
				String path3 = dfile3.getAbsolutePath();
				test.fail("Login not Successfull"
						,MediaEntityBuilder
						.createScreenCaptureFromPath(path3)
						.build());
				//test.addScreenCaptureFromPath(path);
			}
			
			
			extent.flush();
			
			boolean dashboard = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]")).isDisplayed();
			System.out.println("Dashboard"+dashboard);
//			assertEquals(dashboard, true);
			
			
			
	  }
	
	  @BeforeMethod
	  public void beforeMethod(String browsername) throws Exception {
		  
		 System.out.println("This is before method");
		 InputStream input1 = new FileInputStream("D:\\Training\\Eclipse\\Jan2024_SeleniumClass\\src\\test\\java\\Day4\\logindata.properties");
			Properties prob = new Properties();
			prob.load(input1);
			String url = prob.getProperty("url");
			System.out.println("The URL is:" + url);
			//System.out.println("The Browser is:" + browsername);
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(url);
			//Thread.sleep(3000);
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))
	  }

	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("This is after method");
		 // driver.quit();
	  }
	  
	  


	  @DataProvider
	  public Object[][] dp() throws Exception {
		  File f1 = new File("D:\\Training\\Eclipse\\Jan2024_SeleniumClass\\inputdata.xlsx");
	      FileInputStream fis = new FileInputStream(f1);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("Row Count: "+rowCount);
			String[][] data = new String[2][2];
			
			for(int i=0;i<rowCount;i++) {
				data[i][0]=sheet.getRow(i).getCell(0).getStringCellValue();
				data[i][1]=sheet.getRow(i).getCell(1).getStringCellValue();
				String uname = data[i][0];
				String pwd = data[i][1];
				System.out.println("Username: "+uname);
				System.out.println("Password: "+pwd);	
			}
			return data;
	    };
	  
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
		  System.out.println("This is before suite");
	  }
	  

	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("This is after suite");
	  }


}
