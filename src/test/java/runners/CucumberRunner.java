package runners;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;

@Suite
@SuiteDisplayName("Test Automation Example with JUnit 5")
@IncludeEngines("cucumber")
@ExtendWith(SerenityJUnit5Extension.class)
@SelectPackages({"steps", "environment"})
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "io.cucumber.core.plugin.SerenityReporter, utils.StepDetails")
public class CucumberRunner {

}
