package Tests;

import Base.BaseClass;
import Objects.CoronavirusSourceData;
import Utils.CsvHelper;
import Utils.CsvRow;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PrintStatistic extends BaseClass {
    CoronavirusSourceData coronavirusSourceData;

    @Test
    public void PrintStatisticForToday () throws InterruptedException, IOException {
        coronavirusSourceData = new CoronavirusSourceData(driver);
        driver.navigate().to(config.getUrl());
        coronavirusSourceData.getCSVDownloadLink().click();
        Thread.sleep(5000);
        CsvHelper csvHelper = new CsvHelper();
        ArrayList<CsvRow> rows = csvHelper.GetDataFromCSVForToday();
        rows.forEach(row->{
            System.out.println("Country: " + row.getCountry()
                    + ", New cases: " + row.getNewCases()
                    + ", New death: "+ row.getNewDeath()
                    + ", Date: "+ row.getDate());
        });
    }
}