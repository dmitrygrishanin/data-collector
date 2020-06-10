package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CsvHelper {
    ConfigHelper config = new ConfigHelper();

    public ArrayList<CsvRow> GetDataFromCSVForToday() throws IOException {
        String pathToFolder =  Paths.get(".").toAbsolutePath().normalize().toString()+"\\download";
        ArrayList<CsvRow> listOfRows = new ArrayList<>();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date todayDate = new Date();
        String csvFile = pathToFolder+"\\"+config.getDownloadedFilename()+".csv";
        String line = "";
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] row = line.split(cvsSplitBy);
                Date dateFromFile = dateFormatter.parse(row[3]);
                if (dateFormatter.format(dateFromFile).equals(dateFormatter.format(todayDate))) {
                    listOfRows.add(new CsvRow().setCountry(row[2])
                            .setNewCases(Integer.valueOf(row[5]))
                            .setNewDeath(Integer.valueOf(row[7]))
                            .setDate(row[3]));
                }
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return listOfRows;
    }
}


