package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigHelper {
    FileInputStream fis;
    Properties property = new Properties();

    public ConfigHelper() {
        try {
            fis = new FileInputStream("src\\main\\resources\\config.properties");
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        try {
            property.load(fis);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public String getUrl() {
        return property.getProperty("url");
    }

    /*public String getPathToFolder() {
        return property.getProperty("pathToFolder");
    }*/

    public String getDownloadedFilename() {
        return property.getProperty("downloadedFilename");
    }


}
