package com.mod.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src\\test\\java\\com\\mod\\featurefiles", glue = "com.mod.stepdefinitions", tags = "@SmokeTest", plugin = {
		"pretty", "html:target/CucumberHTMLRep.html" })
public class SmokeRunner {

}
