package JulioExercise;


import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;



public class JulioExercise {



		private WebDriver driver;
		private WebDriverWait wait;

		@Test
		public void testSelenium() throws InterruptedException {

		WebDriverManager.chromedriver().version("95").setup();
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--no-sandbox");
	    options.addArguments("--disable-gpu");
	    options.addArguments("--start-maximized");
	    options.addArguments("--incognito");


		wait = new WebDriverWait(driver, 5);
	    driver = new ChromeDriver(options);


	    driver.get("https://www.quecovid.es");

	    List<WebElement> listMenu = driver.findElements(By.xpath("//ul[@id='primary-menu']/li/a/span/span"));

	    listMenu.forEach(x -> System.out.println(x.getText()));

	    List<WebElement> listSocialNetwork = driver.findElements(By.xpath("//div[@class='right-widgets mini-widgets']/div[not(contains(@class,'display-none'))]/a"));

	    listSocialNetwork.forEach(x -> System.out.println(x.getAttribute("href")));

	    driver.findElement(By.xpath("//i[@class=' mw-icon the7-mw-icon-search-bold']")).click();

	    driver.findElement(By.xpath("//input[@name='s']")).sendKeys("postman" + Keys.ENTER);
	    //CustomWaits.waitInMs(5000);
	    Thread.sleep(5000);
	    JavascriptExecutor jse6 = (JavascriptExecutor) driver;
	    jse6.executeScript("window.scrollBy(0,500)", "");
	    //CustomWaits.waitInMs(5000);
	    Thread.sleep(5000);
	    jse6.executeScript("window.scrollBy(0,500)", "");
	    //CustomWaits.waitInMs(5000);
	    Thread.sleep(5000);
	    jse6.executeScript("window.scrollBy(0,500)", "");
	    //CustomWaits.waitInMs(5000);
	    Thread.sleep(5000);
	    jse6.executeScript("window.scrollBy(0,500)", "");
	    List<WebElement> listTitle = driver.findElements(By.xpath("//h3/a"));
	    listTitle.forEach(x -> System.out.println(x.getText()));
	  }

	}


