package com.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class TrelloPage extends BaseClass {

	public TrelloPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[text()='Log in']")
	private WebElement btnLogin;

	@FindBy(id = "user")
	private WebElement txtUser;

	@FindBy(id = "login")
	private WebElement btnContinue;

	@FindBy(xpath = "//div[@class='field-group password-field expanded  css-4k6tso']//descendant::input")
	private WebElement txtPass;

	@FindBy(xpath = "//span[text()='Log in']")
	private WebElement btnLogin1;

	@FindBy(xpath = "//span[text()='Create new board']")
	private WebElement lnkCreateBoard;

	@FindBy(xpath = "//input[@data-test-id='create-board-title-input']")
	private WebElement txtBoardTitle;

	@FindBy(xpath = "//button[text()='Create']")
	private WebElement btnCreate;

	@FindBy(xpath = "//input[@name='name']")
	private WebElement txtListA;

	@FindBy(xpath = "//input[@value='Add list']")
	private WebElement btnaddList;

	@FindBy(xpath = "//span[text()='Add a card']")
	private WebElement lnkAddCard;

	@FindBy(xpath = "//textarea[@placeholder='Enter a title for this card…']")
	private WebElement txtEnterTitle;

	@FindBy(xpath = "//input[@name='name']")
	private WebElement txtListB;

	@FindBy(xpath = "//div[@class='list-card-details js-card-details']")
	private WebElement dragSource;

	@FindBy(xpath = "//a[@class='open-card-composer js-open-card-composer']")
	private WebElement dragDest;

	@FindBy(xpath = "//button[@title='Karthikeyan M (dhanushkarthi876)']")
	private WebElement btnProfile;

	@FindBy(xpath = "//span[text()='Log out']")
	private WebElement btnLogout;

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public WebElement getTxtUser() {
		return txtUser;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public WebElement getTxtPass() {
		return txtPass;
	}

	public WebElement getBtnLogin1() {
		return btnLogin1;
	}

	public WebElement getLnkCreateBoard() {
		return lnkCreateBoard;
	}

	public WebElement getTxtBoardTitle() {
		return txtBoardTitle;
	}

	public WebElement getBtnCreate() {
		return btnCreate;
	}

	public WebElement getTxtListA() {
		return txtListA;
	}

	public WebElement getBtnaddList() {
		return btnaddList;
	}

	public WebElement getLnkAddCard() {
		return lnkAddCard;
	}

	public WebElement getTxtEnterTitle() {
		return txtEnterTitle;
	}

	public WebElement getTxtListB() {
		return txtListB;
	}

	public WebElement getDragSource() {
		return dragSource;
	}

	public WebElement getDragDest() {
		return dragDest;
	}

	public WebElement getBtnProfile() {
		return btnProfile;
	}

	public WebElement getBtnLogout() {
		return btnLogout;
	}

	public void login(String user, String pass) {

		// Login Functionality

		clickElement(getBtnLogin());

		sendKeys(getTxtUser(), user);

		clickElement(getBtnContinue());

		sendKeys(getTxtPass(), pass);

		clickElement(getBtnLogin1());

	}

	public void createList(String title, String ListA, String cardTitle, String ListB) {

		// Create Board

		clickElement(getLnkCreateBoard());

		sendKeys(getTxtBoardTitle(), title);

		clickElement(getBtnCreate());

		// ListA Create

		sendKeys(getTxtListA(), ListA);

		clickElement(getBtnaddList());

		clickElement(getLnkAddCard());

		sendKeys1(getTxtEnterTitle(), cardTitle);

		// ListB Create

		sendKeys1(getTxtListB(), ListB);

		// Drag And Drop

		dragandDrop(getDragSource(), getDragDest());

		xCoordinate(getTxtListA());

		yCoordinate(getTxtListB());

		// Logout Functionality

		clickElement(getBtnProfile());

		clickElement(getBtnLogout());

	}

}
