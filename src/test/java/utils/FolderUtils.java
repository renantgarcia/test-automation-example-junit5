package utils;

import static utils.PropertiesUtils.getProp;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import org.apache.commons.io.FileUtils;

public class FolderUtils {

  public static void emptyReportsFolder() throws IOException {
    File folder = new File(getProp("serenity.properties", "serenity.outputDirectory"));
    for (File f : Objects.requireNonNull(folder.listFiles())) {
      if (f.isDirectory()) {
        FileUtils.cleanDirectory(f);
      }
      if (!f.getName().equals(".gitkeep")) {
        f.delete();
      }
    }
  }

}
