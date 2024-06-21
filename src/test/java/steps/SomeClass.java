package steps;

import static org.junit.jupiter.api.Assertions.*;
import static utils.LogUtils.FANCY;

import environment.Context;
import java.io.IOException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import net.serenitybdd.annotations.Steps;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SomeClass {

    public static final Logger logger = LogManager.getLogger(SomeClass.class);

    @Steps(shared = true)
    Context context;

    @Given("I am who I am")
    public void func1() {
        RestAssured.baseURI = "https://timeapi.io";
        context.httpRequest = RestAssured.given();

        logger.info(FANCY, "End of step");
    }

    @When("I do something")
    public void func2() throws IOException {
        context.httpResponse = context.httpRequest.get("/api/TimeZone/AvailableTimeZones");

        logger.info(FANCY, "End of step");
    }

    @Then("Something happens")
    public void func5() {
        assertEquals(200, context.httpResponse.statusCode());

        logger.info(FANCY, "End of step");
    }

    @Then("Something really amazing happens")
    public void func6() {
        assertEquals(200, context.httpResponse.statusCode());

        logger.info(FANCY, "End of step");
    }

}
