package Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CoronavirusSourceData  {
    ChromeDriver driver;

    public CoronavirusSourceData(ChromeDriver driver) {
        this.driver = driver;
    }

    public WebElement getCSVDownloadLink(){
        return driver.findElementByXPath(" //a[contains(.,'.csv')]");
    }
}
