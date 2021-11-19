package seleniumbootcamp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class OrangeHRMLogin {
	WebDriver driver;
	@Test
	public void login() {
		System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
		 driver=new ChromeDriver();
		
		
		System.setProperty("webdriver.gecko.driver",".\\drivers\\geckodriver.exe");
		 driver=new FirefoxDriver();
		
		System.setProperty("webdriver.edge.driver",".\\drivers\\msedgedriver.exe");
		driver=new EdgeDriver();
		
		
		driver.get("https://opensource-demo.orangehrmlive.com");
		WebElement userName=driver.findElement(By.id("txtUsername"));
		userName.sendKeys("Admin");
		
		WebElement pwd=driver.findElement(By.id("txtPassword"));
		pwd.sendKeys("admin123");
		
		driver.findElement(By.id("btnLogin")).click();
		
		driver.close();
	
	}

}
