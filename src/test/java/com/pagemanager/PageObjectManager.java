package com.pagemanager;

import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.pojo.TrelloPage;

public class PageObjectManager  {

	
	private TrelloPage loginPage;

	public TrelloPage getLoginPage() {
		return (loginPage == null) ? loginPage = new TrelloPage() : loginPage;
	}

}
