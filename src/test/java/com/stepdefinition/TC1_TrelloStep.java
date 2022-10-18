package com.stepdefinition;

import java.awt.AWTException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC1_TrelloStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Given("User is on the Trello page")
	public void userIsOnTheTrelloPage() {

	}
	
	@When("User should perform login {string},{string}")
	public void userShouldPerformLogin(String userName, String password) {
		
		pom.getLoginPage().login(userName, password);
		
	}



	@When("User should create a list")
	public void userShouldCreateAList() {

		pom.getLoginPage().createList("Karthi", "List A", "Enter Username & Password", "List B");
	}

	@Then("User Should Verify Success Message After Logout {string}")
	public void userShouldVerifySuccessMessageAfterLogout(String succMsg) {

		Assert.assertEquals("Verify after login Welcome Msg is present", "https://trello.com/home", succMsg);

	}

}
