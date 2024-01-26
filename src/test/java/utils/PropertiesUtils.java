package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {

  public static String getEnvProp(String property) throws IOException {
    InputStream input = new FileInputStream("target/test-classes/env.properties");
    Properties properties = new Properties();
    properties.load(input);

    return properties.getProperty(property);
  }

  public static String getCucumberProp(String property) throws IOException {
    InputStream input = new FileInputStream("src/test/resources/cucumber.properties");
    Properties properties = new Properties();
    properties.load(input);

    return properties.getProperty(property);
  }

  public static String getSerenityProp(String property) throws IOException {
    InputStream input = new FileInputStream("serenity.properties");
    Properties properties = new Properties();
    properties.load(input);

    return properties.getProperty(property);
  }

}
