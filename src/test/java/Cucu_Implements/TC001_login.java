package Cucu_Implements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_login {

	WebDriver driver;

@Given("Launch the browser")
public void launch_the_browser() {
    // Write code here that turns the phrase above into concrete actions

	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
}

@When("user opens the url1")
public void user_opens_the_url1() {
    // Write code here that turns the phrase above into concrete actions

	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
}

@And("User enter the username1 and password")
public void user_enter_the_username1_and_password() throws Exception {
	Thread.sleep(3000);
    driver.findElement(By.name("username")).sendKeys("Admin");
    driver.findElement(By.name("password")).sendKeys("admin123");
}

@And("Click on login button")
public void click_on_login_button() {
    
	driver.findElement(By.xpath("//button[@type='submit']")).click();
}

@Then("Home page should be displayed")
public void home_page_should_be_displayed() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    boolean dashboard = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).isDisplayed();
    if(dashboard) {
    	System.out.println("Login Unsuccessful");
    }
}
}
