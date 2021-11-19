package seleniumbootcamp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import java.io.File;
public class ExerciseOne {
public static WebDriver driver;

@Before
public void setUp() {
	
	
	String driverPath = System.getProperty("user.dir") + File.separator + "drivers" + File.separator
			+ "chromedriver.exe"; // add .exe for windows

	System.setProperty("webdriver.chrome.driver", driverPath);
	 driver = new ChromeDriver();
}
@After
public void tearDown() {
 driver.quit();
}
@Test
public void chapter1() throws InterruptedException {
 driver.get("https://opensource-demo.orangehrmlive.com/");
 driver.manage().window().setSize(new Dimension(1382, 744));
 driver.findElement(By.id("txtUsername")).click();
 driver.findElement(By.id("txtUsername")).sendKeys("admin");
 driver.findElement(By.id("txtPassword")).sendKeys("admin123");
 driver.findElement(By.id("btnLogin")).click();
 driver.findElement(By.id("welcome")).click();
 Thread.sleep(3000);
 driver.findElement(By.linkText("Logout")).click();
}
}
