package plugins;

import static utils.LogUtils.FANCY;

import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.Step;
import io.cucumber.plugin.event.TestStepStarted;
import io.cucumber.plugin.event.TestStep;
import io.cucumber.plugin.event.PickleStepTestStep;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import steps.AnotherClass;

public class StepPrinter implements EventListener {

  public static final Logger logger = LogManager.getLogger(AnotherClass.class);

  @Override
  public void setEventPublisher(EventPublisher publisher) {
    publisher.registerHandlerFor(TestStepStarted.class, this::handleTestStepStarted);
  }

  private void handleTestStepStarted(TestStepStarted event) {
    TestStep testStep = event.getTestStep();
    if (testStep instanceof PickleStepTestStep pickleStepTestStep) {
      Step step = pickleStepTestStep.getStep();
      logger.info(FANCY, "Step: {}{}", step.getKeyword(), step.getText());
    }
  }
}
