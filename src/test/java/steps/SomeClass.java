package steps;

import environment.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class SomeClass {

  public static final Logger logger = LogManager.getLogger(SomeClass.class);
  private final Context context;

  public SomeClass(Context context) {
    this.context = context;
  }

  @Given("I am who I am")
  public void func1() {
    RestAssured.baseURI = "https://timeapi.io";
    context.httpRequest = RestAssured.given();
    System.out.println("PRINT 1");
  }

  @When("I click somewhere")
  public void func2() {
    context.httpResponse = context.httpRequest.get("/api/TimeZone/AvailableTimeZones");
    System.out.println("PRINT 2");
  }

  @Then("Something really amazing happens")
  public void func5() {
    context.httpResponse.then().assertThat().statusCode(200);
    System.out.println("PRINT 3");
  }

}
