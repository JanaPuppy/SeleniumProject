package seleniumbootcamp;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

class IFrame {

	WebDriver driver=null;
	@BeforeEach
    public void setup() throws Exception {

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        
        
    }

    @AfterEach
    public void aftertest() {
         driver.quit();

    }
    
    @Test
    public void frameDragAndDrop() throws InterruptedException
    {
    	 driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
         Actions action = new Actions(driver);
         WebElement photoframe = driver.findElement(By.xpath("//iframe[contains(@data-src,'photo')]"));
         driver.switchTo().frame(photoframe);
         System.out.println("Switched to frame");
         WebElement source = driver.findElement(By.xpath("//img[contains(@src,'ras3')]"));
         WebElement target = driver.findElement(By.cssSelector("div#trash"));
         action.dragAndDrop(source, target).build().perform();
         Thread.sleep(4000);
         System.out.println("Dragged and Dropped ");
    }

}
