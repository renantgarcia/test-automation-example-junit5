package environment;

import utils.FolderUtils;
import java.io.IOException;
import io.cucumber.java.BeforeAll;

public class Hooks {

  @BeforeAll
  public static void beforeAll() throws IOException {
    FolderUtils.emptyReportsFolder();
  }

}
