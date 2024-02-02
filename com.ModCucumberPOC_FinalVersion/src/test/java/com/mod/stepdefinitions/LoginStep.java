package com.mod.stepdefinitions;

import java.io.IOException;

import com.mod.keywords.FileLibrary;

import io.cucumber.java.en.Given;;

public class LoginStep {

	@Given("Fetch the testdata required {string} {string} {string}")
		public void fetchtestData(String fileName,String sheetName,String scenario) throws IOException {
		FileLibrary.readData(fileName,sheetName,scenario);
	}

}
