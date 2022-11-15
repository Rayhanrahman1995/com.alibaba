package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LogInSteps {
   WebDriver driver;
   
	@Given("user is on the homepage")
	public void user_is_on_the_homepage() {
	   WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
	   driver.get("https://www.alibaba.com/");
	   driver.manage().window().maximize();
	}

	@When("user put the curson on signin button")
	public void user_put_the_curson_on_signin_button() {
	 WebElement signin=driver.findElement(By.xpath("(//a[text()='Sign in'])[1]"));
	 Actions actions=new Actions(driver);
	 actions.moveToElement(signin).build().perform();
	}

	@Then("user click on the signin button")
	public void user_click_on_the_signin_button() {
	    driver.findElement(By.xpath("(//*[text()='Sign in'])[1]")).click();
	}

	@Then("user enters invalid username")
	public void user_enters_invalid_username() {
	    driver.findElement(By.xpath("//input[@id='fm-login-id']")).sendKeys("afshshgs");
	}

	@Then("user enters invalid password")
	public void user_enters_invalid_password() {
	    driver.findElement(By.xpath("//input[@id='fm-login-password']")).sendKeys("454656656");
	}

	@Then("user click on signin button again")
	public void user_click_on_signin_button_again() {
	    driver.findElement(By.xpath("//input[@id='fm-login-submit']")).click();
	}

	@Then("error should displayed")
	public void error_should_displayed() throws InterruptedException {
	 WebElement error=driver.findElement(By.xpath("//span[@class='notice-descript']"));
	 System.out.println("Error: "+error.getText());
	 Thread.sleep(7000);
	}
	
	
	
	
}
