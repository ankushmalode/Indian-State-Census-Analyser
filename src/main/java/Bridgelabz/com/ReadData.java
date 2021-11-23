package Bridgelabz.com;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

//method to load data
public class ReadData {

    public static void main(String[] args) throws CensusAnalyzer {
        String csvFilePath = "D:\\Desk\\ALL\\Day 29\\cencus.csv";
        System.out.println(loadIndiaCensusData(csvFilePath));
    }

    public static int loadIndiaCensusData(String csvFilePath) throws CensusAnalyzer {
        try {
            if (csvFilePath.contains("txt")) {
                throw new CensusAnalyzer("File must be in CSV Format", CensusAnalyzer.ExceptionType.CENSUS_INCORRECT_FILE_FORMAT);
            }
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBean<IndiaCensus> csvToBean = new CsvToBeanBuilder<IndiaCensus>(reader)
                    .withType(IndiaCensus.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<IndiaCensus> iterator = csvToBean.iterator();

            // iterator doesn't consume memory
            Iterable<IndiaCensus> csvIterable = () -> iterator;
            int count = (int) StreamSupport.stream(csvIterable.spliterator(), true).count();
            return count;
        } catch (RuntimeException e) {
            throw new CensusAnalyzer("CSV File Must Have Comma As Delimiter Or Has Incorrect Header", CensusAnalyzer.ExceptionType.CENSUS_WRONG_DELIMITER_OR_WRONG_HEADER);
        } catch (IOException e) {
            throw new CensusAnalyzer(e.getMessage(), CensusAnalyzer.ExceptionType.CENSUS_FILE_INCORRECT);
        }
    }
}