package utils;

import static utils.PropertiesUtils.getSerenityProp;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import org.apache.commons.io.FileUtils;

public class FolderUtils {

  public static void cleanReportsFolder() throws IOException {
    File folder = new File(getSerenityProp("serenity.outputDirectory"));
    try {
      for (File f : Objects.requireNonNull(folder.listFiles())) {
        if (f.isDirectory()) {
          FileUtils.cleanDirectory(f);
        }
        if (!f.getName().equals(".gitkeep")) {
          f.delete();
        }
      }
    } catch (NullPointerException e) {
      System.out.println("The reports folder is empty, nothing to clean");
    }
  }
}
