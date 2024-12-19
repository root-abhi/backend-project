package com.example.app.stepdefinitions;

import com.example.app.App;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;

public class StepDefinitions {

    private App app;
    private String actualGreeting;

    @Given("the application is running")
    public void theApplicationIsRunning() {
        app = new App();
    }

    @When("I greet {string}")
    public void iGreet(String name) {
        actualGreeting = app.greet(name);
    }

    @Then("I should see {string}")
    public void iShouldSee(String expectedGreeting) {
        assertEquals(expectedGreeting, actualGreeting);
    }
}
