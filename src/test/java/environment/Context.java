package environment;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Context {

  public Response httpResponse;
  public RequestSpecification httpRequest;

}
