package com.testorangehrm.runner;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/Features",
glue= {"com.testorangehrm.stepdef"},tags=("@login"),
monochrome = true,
plugin ={"pretty","json:target/cucumber.json"})

public class Runner extends AbstractTestNGCucumberTests{
	
}
