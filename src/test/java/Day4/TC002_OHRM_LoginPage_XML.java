package Day4;

import java.io.File;
import java.time.Duration;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Day3.TC002_ORHM_POM;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_OHRM_LoginPage_XML {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		/*InputStream input1 = new FileInputStream("D:\\Training\\Eclipse\\Jan2024_SeleniumClass\\src\\test\\java\\Day4\\logindata.properties");
		Properties prob = new Properties();
		prob.load(input1);
		String url = prob.getProperty("url");
		System.out.println("The url is: "+url);
		
		
		File f1 = new File("D:\\Training\\Eclipse\\Jan2024_SeleniumClass\\inputdata.xlsx ");
		FileInputStream fis = new FileInputStream(f1);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowcount = sheet.getPhysicalNumberOfRows();
		System.out.println("Row Count" +rowcount);
		
		String[][] data= new String[3][2];
		for (int i=0;i<rowcount;i++) {
			data[i][0]=sheet.getRow(i).getCell(0).getStringCellValue();
			data[i][1]=sheet.getRow(i).getCell(1).getStringCellValue();
			String uname = data[i][0];
			String pword = data[i][1];*/
		
		File xmlFile = new File("D:\\Training\\Eclipse\\Jan2024_SeleniumClass\\src\\test\\java\\Day4\\logindata.xml");
		DocumentBuilderFactory DBfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbuilder = DBfactory.newDocumentBuilder();
		 Document doc = dbuilder.parse(xmlFile);
		 NodeList n1 = doc.getChildNodes();
		 Node n = n1.item(0);
		 Element ele = (Element)n;
		 String url = ele.getElementsByTagName("url").item(0).getTextContent();
		 String uname = ele.getElementsByTagName("username").item(0).getTextContent();
		 String pword = ele.getElementsByTagName("password").item(0).getTextContent();
		 
		
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get(url);
			System.out.println("Username: "+uname);
			System.out.println("Password: "+pword);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			TC002_ORHM_POM obj = new TC002_ORHM_POM(driver);
			obj.enteruname(uname);
			obj.enterpword(pword);
			obj.clicklogin();
		}
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		
//		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");   //by using xpath
//		driver.findElement(By.name("password")).sendKeys("admin123");
//		driver.findElement(By.xpath("//button[@type='submit']")).submit();
	
	}


