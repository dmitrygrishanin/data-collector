package Base;

import Utils.ConfigHelper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public ChromeDriver driver;
    public ConfigHelper config;

    @BeforeSuite
    public void SetUp() throws IOException {
        String pathToFolder =  Paths.get(".").toAbsolutePath().normalize().toString()+"\\download";
        config = new ConfigHelper();

        // Clean downloads folder
        FileUtils.cleanDirectory(new File(pathToFolder));

        // Set download path
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", pathToFolder);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(ChromeOptions.CAPABILITY, options);

        // Set path to driver
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        // Create a new instance of Chrome driver
        driver = new ChromeDriver(cap);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

   @AfterSuite
    public void TearDown(){
        driver.quit();
    }
}
