package environment;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;

public class Context {

  public WebDriver webdriver;
  public Response httpResponse;
  public RequestSpecification httpRequest;

}
