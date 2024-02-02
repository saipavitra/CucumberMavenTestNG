package com.mod.testrunner;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.testng.annotations.AfterClass;

import net.masterthought.cucumber.*;

public class jvmReportPractice {

	@AfterClass
	public static void reportGeneration(String json) {
		// TODO Auto-generated method stub
		List<String> list =new LinkedList<String>();
		list.add(json);//path of json report that is already generated in cucumber framework
		File file =new File("\\com.ModCucumberPOC\\testData\\CarrierProfile");
		Configuration config1=new Configuration(file, "NTG");
		config1.addClassifications("BrowserName", "chrome");
	    ReportBuilder rpBuild=new ReportBuilder(list,config1);
	    rpBuild.generateReports();
	}
}
