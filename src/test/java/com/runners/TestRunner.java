package com.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features"
		,glue={"com.stepdefs"}
		,tags={"@e2eLogin"}
		,monochrome=true
		,plugin = { "pretty", "pretty:target/cucumber-reports/pretty.txt",
					"html:target/cucumber-reports",
					"json:target/cucumber-reports/cucumber.json"
				
					}
		//,dryRun= true
		)

public class TestRunner {

}
