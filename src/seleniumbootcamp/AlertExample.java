package seleniumbootcamp;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertExample {


	WebDriver driver;

	@BeforeEach
	public void setup() {

		System.out.println("*****pre-condition*****");
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://only-testing-blog.blogspot.com/2013/11/new-test.html");

	}

	@AfterEach
	public void teardown() throws Exception {

		System.out.println("*****post-condition*****");
		Thread.sleep(4000);
		driver.close();

	}


	@Test
	public void Test_01() throws Exception { 

		//generate alert
		driver.findElement(By.xpath("//input[@value='Show Me Alert']")).click();
		//StichTo - alert/window/frame

		Alert alert_demo = driver.switchTo().alert();

		String text = alert_demo.getText(); System.out.println(text);
		Assert.assertTrue(text.contains("alert message")); Thread.sleep(1000);
		alert_demo.accept();

	}



	@Test 
	public void Test_02() throws Exception { 
		//generate alert confirmation
		driver.findElement(By.xpath("//button[text()='Show Me Confirmation']")).click (); //StichTo - alert/window/frame

		Alert alert_demo = driver.switchTo().alert();

		String text = alert_demo.getText(); System.out.println(text);
		Assert.assertTrue(text.contains("OK' or 'Cancel'")); Thread.sleep(1000);
		alert_demo.accept(); 
		//alert_demo.dismiss();

		String confirm_text = driver.findElement(By.id("demo")).getText();
		System.out.println("**********" +confirm_text);
		Assert.assertTrue(confirm_text.contains("OK"));
		Assert.assertTrue(confirm_text.contains("Cancel")); }



	@Test
	public void Test_03() throws Exception {
		//generate alert prompt
		driver.findElement(By.xpath("//button[text()='Show Me Prompt']")).click();
		//StichTo - alert/window/frame

		Alert alert_demo = driver.switchTo().alert();

		String text = alert_demo.getText();
		System.out.println(text);
		Assert.assertTrue(text.contains("Your Name Please"));
		//actual and expected 

		Thread.sleep(1000);
		alert_demo.sendKeys("Abhishek");

		Thread.sleep(3000);

		//alert_demo.accept();
		alert_demo.dismiss();


	}
}



