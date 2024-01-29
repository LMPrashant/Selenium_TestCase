package Day5_TestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003_ORHM_login {
	
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void f(String n, String s, String p) {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.name(n)).sendKeys("Admin");   //by using xpath
		driver.findElement(By.name(s)).sendKeys("admin123");
		driver.findElement(By.xpath(p)).submit();
  }
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  InputStream input1 = new FileInputStream("D:\\Training\\Eclipse\\Jan2024_SeleniumClass\\src\\test\\java\\Day5_TestNG\\orhm.properties");
		Properties prop = new Properties();
		prop.load(input1);
		String url = prop.getProperty("url");
		 
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider
  public Object[][] dp() throws Exception {
	  
	  File xmlFile = new File("D:\\Training\\Eclipse\\Jan2024_SeleniumClass\\src\\test\\java\\LABs_XML\\loginCssORHM.xml");
		DocumentBuilderFactory DBfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbuilder = DBfactory.newDocumentBuilder();
		 Document doc = dbuilder.parse(xmlFile);
		 NodeList n1 = doc.getChildNodes();
		 Node n = n1.item(0);
		 Element ele = (Element)n;
		 String usern = ele.getElementsByTagName("username").item(0).getTextContent();
		 String pass = ele.getElementsByTagName("password").item(0).getTextContent();
		 String logbtn = ele.getElementsByTagName("loginbtn").item(0).getTextContent();
		 System.out.println("Username: "+usern);
		 System.out.println("Password: "+pass);
    return new Object[][] {
      new Object[] { usern, pass, logbtn },
      new Object[] { usern, pass,logbtn },
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
