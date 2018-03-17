package analysis;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CharAnalysis extends StatisticalAnalysis{
    private Map<String, Integer> letterStatistics;
    private Integer totalCharCount;

    public CharAnalysis(Iterator<String> iterator) {  //zmienić na specyficzny. tak samo w word
        super(iterator);
        letterStatistics = getOccurrenceStatistics();
        totalCharCount = size();
    }

    public Integer vowelsPercentage(){
        Integer totalVowelsCount = 0;

        totalVowelsCount =  letterStatistics
                .entrySet()
                .stream()
                .filter(entry -> Pattern.matches("[EUIOA]", entry.getKey())) //WHERE IS Y???
                .mapToInt(entry -> entry.getValue())
                .sum();

        return totalVowelsCount * 100 / totalCharCount;
    }

    public Double vowelsRatio(String firstLetter, String secondLetter){

        Integer firstValue = letterStatistics.get(firstLetter.toUpperCase());
        Integer secondValue = letterStatistics.get(secondLetter.toUpperCase());

        if(firstValue == null || secondValue == null){
            return 0d;
        }
        return roundToDecimalFormat((double)firstValue/secondValue);
    }

    public Map<String, Double> getLettersPercentageStatistics(){

        return letterStatistics.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> roundToDecimalFormat(entry.getValue() * 100d/totalCharCount)
                ));

    }

    private Double roundToDecimalFormat(Double number){
        return (Math.floor(number*100))/100;

    }

}
