package steps;

import static org.junit.jupiter.api.Assertions.*;
import static utils.StepDetails.stepName;

import environment.Context;
import java.io.IOException;
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
        System.out.println("  Step: Given " + stepName);

        RestAssured.baseURI = "https://timeapi.io";
        context.httpRequest = RestAssured.given();

        System.out.println("PRINT 1");
    }

    @When("I click somewhere")
    public void func2() throws IOException {
        System.out.println("  Step: When " + stepName);

        context.httpResponse = context.httpRequest.get("/api/TimeZone/AvailableTimeZones");

        System.out.println("PRINT 2");
    }

    @Then("something really amazing happens")
    public void func5() {
        System.out.println("  Step: Then " + stepName);

        assertEquals(200, context.httpResponse.statusCode());

        System.out.println("PRINT 3");
    }

    @Then("something really crappy happens")
    public void func6() {
        System.out.println("  Step: Then " + stepName);

        assertEquals(542, 200); //context.httpResponse.statusCode());

        System.out.println("PRINT 4");
    }

}
