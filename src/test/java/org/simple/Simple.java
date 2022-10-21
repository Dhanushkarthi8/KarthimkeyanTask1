package org.simple;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Simple {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://trello.com/en");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement btnLogin = driver.findElement(By.xpath("//a[text()='Log in']"));

		btnLogin.click();

		WebElement txtUser = driver.findElement(By.id("user"));

		txtUser.sendKeys("dhanushkarthi876@gmail.com");

		WebElement btnContinue = driver.findElement(By.id("login"));

		btnContinue.click();

		WebElement txtPassword = driver.findElement(
				By.xpath("//div[@class='field-group password-field expanded  css-4k6tso']//descendant::input"));

		txtPassword.sendKeys("Karthi@87600");

		WebElement btnLogin1 = driver.findElement(By.xpath("//span[text()='Log in']"));

		btnLogin1.click();

		driver.findElement(By.xpath("//span[text()='Create new board']")).click();

		driver.findElement(By.xpath("//input[@data-test-id='create-board-title-input']")).sendKeys("Karthi");
		driver.findElement(By.xpath("//button[text()='Create']")).click();
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("List A", Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='Add a card']")).click();

		driver.findElement(By.xpath("//input[@value='Add list']")).click();
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("List B", Keys.ENTER);

		driver.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']"))
				.sendKeys("Enter Username & Password", Keys.ENTER);

		WebElement src = driver.findElement(By.xpath("//div[@class='list-card-details js-card-details']"));

		WebElement des = driver.findElement(By.xpath("//a[@class='open-card-composer js-open-card-composer']"));

		Actions actions = new Actions(driver);

		actions.dragAndDrop(src, des).perform();

		driver.findElement(By.xpath("//button[@title='Karthikeyan M (dhanushkarthi876)']")).click();

		driver.findElement(By.xpath("//span[text()='Log out']")).click();
	}
}
