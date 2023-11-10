package steps;

import static utils.LogUtils.FANCY;
import static utils.LogUtils.SIMPLE;
import static utils.LogUtils.SIMPLE_NEW_LINE;
import environment.Context;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AnotherClass {

  public static final Logger logger = LogManager.getLogger(SomeClass.class);
  private Context context;

  public AnotherClass(Context context) {
    this.context = context;
  }

  @Then("I am going to use the context")
  public void func6() {
    logger.info(FANCY, "PRINT 4");
    logger.info(SIMPLE_NEW_LINE, context.httpResponse.getBody().asPrettyString());
    logger.info(SIMPLE_NEW_LINE, context.httpResponse.getHeaders().asList());
    logger.info(SIMPLE, "======================================================");
  }

}
