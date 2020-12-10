package com.qa.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="classpath:features",
		glue="com/qa/stepdefinitions",
		plugin = {
		             "pretty", "json:target/cucumber-reports/cucumber-test-report.json",
		             "html:target/cucumber-reports/cucumber-test-report.html" },
		dryRun=false
		
		)

public class RunnerTest {

}
