package steps;

import static plugins.StepDetails.stepName;
import static utils.PropertiesUtils.getProp;

import java.io.IOException;

import environment.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import net.serenitybdd.annotations.Steps;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class SomeClass {

  public static final Logger logger = LogManager.getLogger(SomeClass.class);

  @Steps(shared = true)
  Context context;

  @Given("I am who I am")
  public void func1() {
    System.out.println("Step: " + stepName);
    RestAssured.baseURI = "https://timeapi.io";
    context.httpRequest = RestAssured.given();
    System.out.println("PRINT 1");
  }

  @When("I click somewhere")
  public void func2() throws IOException {
    System.out.println("Step: " + stepName);
    context.httpResponse = context.httpRequest.get("/api/TimeZone/AvailableTimeZones");
    System.out.println("THE ENV IS THIS " + getProp("target/test-classes/env.properties", "env"));
    System.out.println("PRINT 2");
  }

  @Then("Something really amazing happens")
  public void func5() {
    System.out.println("Step: " + stepName);
    context.httpResponse.then().assertThat().statusCode(200);
    System.out.println("PRINT 3");
  }

}
