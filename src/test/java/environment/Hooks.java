package environment;

import static utils.LogUtils.FANCY;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.annotations.Steps;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import steps.AnotherClass;
import utils.FolderUtils;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks {

  public static final Logger logger = LogManager.getLogger(AnotherClass.class);

  @Steps(shared = true)
  static Context context = new Context();

  @BeforeAll
  public static void beforeAll() throws IOException {
    FolderUtils.cleanReportsFolder();

    logger.info(FANCY, "Starting all the things");
  }

  @Before
  public static void beforeScenario(Scenario scenario) throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    Thread.sleep(3000);
    context.webdriver = driver;

    logger.info(FANCY, "Scenario: {}", scenario.getName());
  }

  @After
  public static void afterScenario(Scenario scenario) {
    Capabilities caps = ((ChromeDriver) context.webdriver).getCapabilities();
    logger.info(FANCY, "Browser version: {}", caps.getBrowserVersion());
    context.webdriver.quit();

    logger.info(FANCY, "End of scenario");
  }

  @AfterAll
  public static void afterAll() {
    logger.info(FANCY, "Finishing all the things");
  }

}
