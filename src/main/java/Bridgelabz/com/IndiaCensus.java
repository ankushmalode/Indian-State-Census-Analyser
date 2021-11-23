package Bridgelabz.com;

import com.opencsv.bean.CsvBindByName;

public class IndiaCensus {
    @CsvBindByName(column = "State")
    public String state;

    @CsvBindByName(column = "Population")
    public String population;

    @CsvBindByName(column = "AreaInSqKm")
    public String areaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm")
    public String densityPerSqKm;


    @Override
    public String toString() {
        return "IndiaCensusCSV{" +
                "state='" + state + '\'' +
                ", population='" + population + '\'' +
                ", areaInSqKm='" + areaInSqKm + '\'' +
                ", densityPerSqKm='" + densityPerSqKm + '\'' +
                '}';
    }
}
