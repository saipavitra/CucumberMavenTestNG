package com.mod.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src\\test\\java\\com\\mod\\featurefiles", glue = "com.mod.stepdefinitions", tags="@RegressionTest or @SmokeTest" , plugin = {
		"pretty", "html:target/CucumberHTMLRep.html", "json:target/CucumberHTMLRep.json", "junit:target/CucumberHTMLRep.xml"}, monochrome=true, snippets=SnippetType.UNDERSCORE, strict=true)
public class RegressionRunner {

}

//tags - not @RegressionTest or @SmokeTest (in this case : it omits regressionTest and runs smokeTests) / if 'and' is given between each tags , it will check for both the tags if is present or not // if 'or' is present , then it will check if any one of the tag is present in feature file , it will run
//DryRun can be placed under CucumberOptions tag-> if DryRun=true (tells which step definitions haven't been declared will be printed in console) (once the run is pressed , the missing snippets will be printed in the console before entering into the actual program)
//4 types of reports will be generated here for this Runner class :
//pretty: results will display as key and value pairs but sometimes it will have unreadable formats , that's y monochrome=true can be used
//html: result will display as a html format
//json: results will display as json format
//junit: results will display as xml format
//usual: results will display in a format of json
//monochrome=true :unreadable characters will be removed || monochrome=false :unreadable characters will be displayed
//snippets=SnippetType.UNDERSCORE : missed out step definitions will display in the console output using underscore inbetween of the words
//snippets=SnippetType.CAMELCASE : missed out step definitions will display in the console output using camelCase inbetween of the words 
//strict=true: if Strict option is set to true then at execution time if cucumber encounters any undefined/pending steps then cucumber does fails the execution and undefined steps are marked as fail and BUILD is FAILURE.
//inbetween tags , (if , is placed between 2 tags , then operation is considered as "or")/( if "," is placed between 2 tags , then operation is considered as and )

//DataTable -> https://www.tutorialspoint.com/cucumber/cucumber_data_tables.htm
//@wip tag in feature file ->If any scenario tagged as @wip passes all of its steps without error, and the --wip option is also passed, Cucumber reports the run as failing (because Scenarios that are marked as a work in progress are not supposed to pass!)