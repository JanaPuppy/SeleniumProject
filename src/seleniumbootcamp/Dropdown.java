package seleniumbootcamp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

class Dropdown {
	WebDriver driver;
	@Test
	public void login() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
		 driver=new ChromeDriver();
		
		
		
		driver.manage().window().maximize();
		
		driver.get("http://only-testing-blog.blogspot.com/2013/11/new-test.html");
		WebElement list=driver.findElement(By.xpath("//div/select"));
		Select drpdwn=new Select(list);
		drpdwn.selectByIndex(3);
		Thread.sleep(4000);
		//String selectedval=list.getAttribute(drpdwn);
	
		
		
		
		driver.close();
	
	}

}
