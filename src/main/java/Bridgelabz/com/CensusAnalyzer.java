package Bridgelabz.com;

public class CensusAnalyzer extends Exception{
    public enum ExceptionType {
        CENSUS_FILE_INCORRECT, CENSUS_INCORRECT_FILE_FORMAT, CENSUS_WRONG_DELIMITER_OR_WRONG_HEADER;
    }

    public ExceptionType type;
    public CensusAnalyzer(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    @Override
    public String toString() {
        return "CensusAnalyserException{" +
                "type=" + type +
                '}';
    }
}
