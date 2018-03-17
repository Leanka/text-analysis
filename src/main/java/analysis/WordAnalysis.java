package analysis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WordAnalysis extends StatisticalAnalysis{

    public WordAnalysis(Iterator<String> iterator) {
        super(iterator);
    }

    public List<String> mostUsedWordsByPercen(Integer percent){
        List <String> mostUsedWords = new ArrayList<>();
        Map<String, Integer> usageStatistics = getOccurrenceStatistics();
        Double occurrenceLevel = size() * (percent * 0.01);

        for (Map.Entry<String, Integer> entry: usageStatistics.entrySet()){
            if(entry.getValue() > occurrenceLevel){
                mostUsedWords.add(entry.getKey());
            }
        }
        return mostUsedWords;
    }
}
