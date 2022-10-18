package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HookClass extends BaseClass {

	@Before
	public void beforeScenario() throws FileNotFoundException, IOException {

		getDriver(getPropertyFileValue("browserType"));
		enterUrl(getPropertyFileValue("url"));
		implicitlyWaits(10);
		windowMax();
	}

	@After
	public void afterScenario(Scenario scenario) {

		scenario.attach(screenShot(), "images/png", "All Scenarios");

	}

}
