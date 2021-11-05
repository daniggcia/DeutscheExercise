package com.db.automation;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;



public class Runner {

	private WebDriver driver;
	private WebDriverWait wait;
	@Test
	public void runTest() {

		String mainUrl = "https://dbonline.deutsche-bank.es/portalserver/olbesportal/login";
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-gpu");
		options.addArguments("--start-maximized");

		options.addArguments("--incognito");
		driver = new ChromeDriver(options);

		driver.get("https://dbonline.deutsche-bank.es/portalserver/olbesportal/login");

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

		wait = new WebDriverWait(driver, 1);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='dbLoginForm-dni']")))
				.sendKeys("53449788o");
		wait = new WebDriverWait(driver, 1);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Siguiente']"))).click();

		String pageText = driver.findElement(By.xpath("//div[@class='db-login-form-error ng-binding']")).getText();
		Assert.assertTrue(pageText.contentEquals("Tus datos no son correctos. Por favor, infórmalos de nuevo"));


	}
}