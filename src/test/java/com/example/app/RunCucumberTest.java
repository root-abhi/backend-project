package com.example.app;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/com/example/app/features",
    glue = "com.example.app.stepdefinitions",
    plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class RunCucumberTest {}
