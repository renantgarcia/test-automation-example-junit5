package steps;

import static utils.LogUtils.FANCY;

import environment.Context;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AnotherClass {

  public static final Logger logger = LogManager.getLogger(AnotherClass.class);

  @Steps(shared = true)
  Context context;

  @Then("I am going to use the context")
  public void func6() {
    logger.info(FANCY, "CONTEXT!");
    logger.info(FANCY, context.httpResponse.getHeader("Connection"));
    logger.info(FANCY, "End of step");
  }

}
