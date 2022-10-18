package com.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.reports.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(snippets = SnippetType.CAMELCASE, publish = true, dryRun = false, stepNotifications = true, monochrome = true, plugin = {
		"pretty", "json:target//out.json" }, features = "src\\test\\resources\\Features", glue = "com.stepdefinition")

public class TestRunnerClass extends BaseClass {

	@AfterClass
	public static void afterClass() throws FileNotFoundException, IOException {

		Reporting.generateJVMReport(System.getProperty("user.dir") + getPropertyFileValue("jsonPath"));

	}

}
