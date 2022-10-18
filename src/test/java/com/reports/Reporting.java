package com.reports;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.base.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

/**
 * 
 * @author KARTHIKEYAN
 * @description Used TO Generate JVM Report
 * @date 10-09-2022
 *
 */
public class Reporting {

	public static void generateJVMReport(String jsonFile) throws FileNotFoundException, IOException {

		File file = new File(System.getProperty("user.dir") + "\\target");

		Configuration configuration = new Configuration(file, "OMRBranchAdactinHotelAutomation");

		configuration.addClassifications("OS", "WINDOWS 10");
		configuration.addClassifications("BrowserType", "Chrome");
		configuration.addClassifications("Version", "104");
		configuration.addClassifications("Sprint", "8");

		List<String> jsonFiles = new ArrayList<String>();

		jsonFiles.add(jsonFile);

		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);

		builder.generateReports();

	}

}
