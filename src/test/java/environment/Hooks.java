package environment;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.FolderUtils;
import java.io.IOException;
import io.cucumber.java.BeforeAll;

public class Hooks {

  @BeforeAll
  public static void beforeAll() throws IOException {
    FolderUtils.emptyReportsFolder();
  }

  @Before
  public static void beforeScenario(Scenario scenario) {
    System.out.println("Scenario: " + scenario.getName());
  }

}
