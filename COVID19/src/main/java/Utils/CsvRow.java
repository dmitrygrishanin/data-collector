package Utils;

public class CsvRow {
    String country;
    Integer newCases;
    Integer newDeath;
    String date;

    public String getCountry() {
        return country;
    }

    public CsvRow setCountry(String country) {
        this.country = country;
        return this;
    }

    public Integer getNewCases() {
        return newCases;
    }

    public CsvRow setNewCases(Integer newCases) {
        this.newCases = newCases;
        return this;
    }

    public Integer getNewDeath() {
        return newDeath;
    }

    public CsvRow setNewDeath(Integer newDeath) {
        this.newDeath = newDeath;
        return this;
    }

    public String getDate() {
        return date;
    }

    public CsvRow setDate(String date) {
        this.date = date;
        return this;
    }
}
