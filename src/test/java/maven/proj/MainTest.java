package maven.proj;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import twitter.TwitterPage;

public class MainTest extends TwitterPage {

	private ChromeDriver driver;
	private TwitterPage twitterPage;
	private String login = "";
	private String pswd = "";

	@Before
	public void beforeTests() {
		//TO DO
		//fix driver path
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@After
	public void teaeDown() {
		driver.close();
	}

	@Test
	public void nihuyaTest() throws InterruptedException {
		System.out.print("@echo Test");
		driver.get("https://twitter.com/");
		driver.findElementByCssSelector("#doc > div.StreamsTopBar-container.StreamsTopBar-container--withStreamHero.StreamsTopBar-container--withTallHeader > div > div.StreamsHero > div.StreamsHero-buttonContainer > button")
		.click();
		
		driver.findElementById("signin-email").sendKeys(login);
		driver.findElementById("signin-password").sendKeys(pswd);
		driver.findElementByCssSelector("#login-dialog-dialog > div.LoginDialog-content.modal-content > div.LoginDialog-body.modal-body > div.LoginDialog-form > form > input.submit.btn.primary-btn.js-submit")
		.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://twitter.com/thenonamepaul/following");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		for (int i = 80 ; i > 0 ; i--){
			driver.navigate().refresh();
			WebDriverWait wait = new WebDriverWait(driver, 40);
		    WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".user-actions-follow-button")));
		    
		    List<WebElement> elementsList = new ArrayList<WebElement>(); 
		    elementsList =  driver.findElementsByCssSelector(".user-actions-follow-button");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			for(WebElement unsubscribe:elementsList) {
			    try {
			    	unsubscribe.click();
			    	System.out.println("-------------------end keep going-------------------------");
			    	} 
			    catch (Exception e) {
			    	System.out.println(e);
			    	System.out.println("-----------------------------------------------------------------");
			    	System.out.println("-----------------------------------------------------------------");
			    	driver.get("https://twitter.com/thenonamepaul/following");
			    };
			}
			driver.navigate().refresh();
//			jse.executeScript("window.scrollBy(0,250)", "");
//			jse.executeScript("window.scrollBy(0,250)", "");
			
		
		}
		
	}

}
