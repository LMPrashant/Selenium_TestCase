package PropertiesLab;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;

	public class LAB12_DemoCart_Pom {
		WebDriver driver;
		By dt = By.linkText("Desktops");
		By mc = By.linkText("Mac (1)");
		By sorting = By.xpath("//*[@id=\"input-sort\"]");

		By sbutton1 = By.xpath("//*[@id=\"search\"]/button");
		By sbox = By.xpath("//*[@id=\"input-search\"]");
		By cbox = By.xpath("//*[@id=\"input-description\"]");
		By sbutton = By.xpath("//*[@id=\"button-search\"]");
		
		public LAB12_DemoCart_Pom(WebDriver driver2) {
			this.driver=driver2;
		}
		
		public void desktop() throws Exception {
			Thread.sleep(2000);
			WebElement ele = driver.findElement(dt);
		    Actions act = new Actions(driver);
			act.moveToElement(ele).perform();
		}
		
		public void mac() {
			driver.findElement(mc).click();
		}
		
		public void sort(int i) throws Exception {
			driver.findElement(sorting).click();
			Select sort = new Select(driver.findElement(sorting));
			Thread.sleep(3000);
			sort.selectByIndex(i);
		}
		
		public void search() {
			driver.findElement(sbutton1).click();
		}
		
		public void search2(String text) {
			driver.findElement(sbox).sendKeys(text);
		}
		
		public void tick() {
			driver.findElement(cbox).click();
		}
		
		public void searchbutton() {
			driver.findElement(sbutton).click();
		}
		public void clear2() {
			driver.findElement(sbox).clear();
		}
	}

