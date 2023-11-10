package steps;

import static utils.LogUtils.FANCY;
import static utils.LogUtils.SIMPLE;
import static utils.LogUtils.SIMPLE_NEW_LINE;
import environment.Context;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AnotherClass {

  public static final Logger logger = LogManager.getLogger(SomeClass.class);

  @Steps(shared = true)
  Context context;

  @Then("I am going to use the context")
  public void func6() {
    logger.info(FANCY, "PRINT 4");
    logger.info(SIMPLE_NEW_LINE, context.httpResponse.getBody().asPrettyString());
    logger.info(SIMPLE_NEW_LINE, context.httpResponse.getHeaders().asList());
    logger.info(SIMPLE, "======================================================");
  }

}
