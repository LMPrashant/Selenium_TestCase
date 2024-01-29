package Day3;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC005_OHRM_LoginPage {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

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
			String pword = data[i][1];
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
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

}
