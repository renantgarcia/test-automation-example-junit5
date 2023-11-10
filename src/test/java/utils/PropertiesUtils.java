package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {

  public static String getProp(String path, String property) throws IOException {
    InputStream input = new FileInputStream(path);
    Properties properties = new Properties();
    properties.load(input);

    return properties.getProperty(property);
  }

}
