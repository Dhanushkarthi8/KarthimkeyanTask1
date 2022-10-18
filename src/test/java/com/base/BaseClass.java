package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {

		Properties properties = new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir") + "\\Config\\Config.properties"));

		String value = (String) properties.get(key);
		return value;
	}

	public byte[] screenShot() {
		TakesScreenshot ts = (TakesScreenshot) (driver);

		byte[] b = ts.getScreenshotAs(OutputType.BYTES);

		return b;

	}

	public static void getDriver(String browserType) {

		switch (browserType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		default:
			break;
		}

	}

	public static void enterUrl(String url) {
		driver.get(url);
	}

	public static void windowMax() {
		driver.manage().window().maximize();
	}

	public void closeCurrentWindow() {
		driver.close();
	}

	public void dragAndDrop(WebElement source, WebElement target) {

		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();
	}

	public void xCoordinate(WebElement element) {

		int getX = element.getLocation().getX();

		System.out.println("X coordinate:" + getX);
	}

	public void yCoordinate(WebElement element) {

		int getY = element.getLocation().getY();
		System.out.println("Y coordinate:" + getY);
	}

	public void sendKeys(WebElement element, String data) {
		element.sendKeys(data);
	}

	public void sendKeys1(WebElement element, String data) {
		element.sendKeys(data, Keys.ENTER);
	}

	public void clickElement(WebElement element) {
		element.click();
	}

	public String getText(WebElement element) {
		String text = element.getText();
		System.out.println(text);
		return text;

	}

	public String getAttribute(WebElement element) {
		String att = element.getAttribute("value");
		System.out.println(att);
		return att;
	}

	public static void alertBoxOk() {

		driver.switchTo().alert().accept();

	}

	public void implicitlyWaits1(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	// 1.
	public static void getDriver() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
	}

	// 4.
	public String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		return currentUrl;

	}

	// 5.
	public String getTitle() {
		String title = driver.getTitle();
		return title;

	}

	// 22.
	public void mouseOver(WebElement element) {

		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();

	}

	// 23.
	public void dragandDrop(WebElement source, WebElement target) {

		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();

	}

	// 39.
	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	// 40.
	public void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	// 58

	public void sleep(long millis) throws InterruptedException {

		Thread.sleep(millis);
	}

	// 59.
	public static void implicitlyWaits(int value) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(value));

	}

}
