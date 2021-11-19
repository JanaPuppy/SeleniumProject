package seleniumbootcamp;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {
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
    public void mouseHoverClick()
    {
    	driver.get("https://www.amazon.in/");
    	Actions act=new Actions(driver);
    	WebElement sign=driver.findElement(By.id("nav-link-accountList"));
    	WebElement account=driver.findElement(By.xpath("//span[text()='Your Account']"));
    	
    	act.moveToElement(sign).moveToElement(account).click().perform();
    	
    	WebElement login=driver.findElement(By.xpath("//*[@data-card-identifier='SignInAndSecurity']"));
    	assertTrue(login.isDisplayed());
    	System.out.println("Login is displayed");
    	
    }
    
    @Test
    public void DoubleClick() throws Exception {
         driver.get("https://demo.guru99.com/test/simple_context_menu.html");
         Actions action = new Actions(driver);
         WebElement ele = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
         action.doubleClick(ele).perform();
         Thread.sleep(3000);
         System.out.println("double click");
        
        
        
    }
    
    
    @Test
    public void RightClick() throws Exception {
    	driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        Actions action = new Actions(driver);
         WebElement ele = driver.findElement(By.xpath("//span[text()='right click me']"));
         action.contextClick(ele).perform();
        driver.findElement(By.xpath("//span[text()='Delete']")).click();
        Thread.sleep(3000);
        System.out.println("right click ");
        
    }
    
    @Test
    public void ListBox_Handling() throws Exception {

        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://jqueryui.com/droppable/");
        WebElement photoframe = driver.findElement(By.xpath("//iframe[contains(@src,'demos')]"));
        driver.switchTo().frame(photoframe);
        WebElement source1 = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement target1 = driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions action = new Actions(driver);
        //action.dragAndDrop(source1, target1).build().perform();
        action.clickAndHold(source1).moveToElement(target1).release().build().perform();
        
        
        
        /*
         * WebElement moveonmenu =
         * driver.findElement(By.xpath("//div[@id='menu1']/div"));
         * actions.moveToElement(moveonmenu).moveToElement(driver.findElement(By.xpath(
         * "//div[@id='menu1choices']/a[2]"))) .click().perform();
         * 
         * WebDriverWait wait = new WebDriverWait(driver, 15);
         * wait.until(ExpectedConditions.titleContains("Google"));
         */

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


