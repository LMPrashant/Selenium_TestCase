package LABs;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LAB14_OpenCartRegister {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		File f1 = new File("D:\\Training\\Eclipse\\Jan2024_SeleniumClass\\register.xlsx ");
		FileInputStream fis = new FileInputStream(f1);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowcount = sheet.getPhysicalNumberOfRows();
		System.out.println("Row Count" +rowcount);
		
		String [][] data = new String [2][4];
		for(int i=0;i<rowcount;i++) {
			data[i][0]=sheet.getRow(i).getCell(0).getStringCellValue();
			data[i][1]=sheet.getRow(i).getCell(1).getStringCellValue();
			data[i][2]=sheet.getRow(i).getCell(2).getStringCellValue();
			data[i][3]=sheet.getRow(i).getCell(3).getStringCellValue();
			String fname = data[i][0];
			String lname = data[i][1];
			String email = data[i][2];
			String pass = data[i][3];
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			System.out.println("Firstname: "+fname);
			System.out.println("LastName: "+lname);
			System.out.println("Email: "+email);
			System.out.println("Password: "+pass);
			
			driver.get("https://demo.opencart.com/");
			driver.findElement(By.linkText("My Account")).click();
			driver.findElement(By.linkText("Register")).click();
			
			LAB14_OpenCart_POM obj = new LAB14_OpenCart_POM(driver);
			obj.enterfirstname(fname);
			obj.enterlastname(lname);
			obj.enteremail(email);
			obj.enterpassword(pass);
			Thread.sleep(2000);
			obj.radiobtn();
			Thread.sleep(2000);
			obj.checkbox();
			obj.submitbtn();
			
			
		}
	}

}
