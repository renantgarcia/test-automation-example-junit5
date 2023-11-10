package runners;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;

@Suite
@SuiteDisplayName("Test Automation Example with JUnit 5")
@IncludeEngines("cucumber")
@SelectClasspathResource("features")

public class CucumberRunner {

}
