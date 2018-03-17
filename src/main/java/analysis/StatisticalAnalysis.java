package analysis;

import java.util.*;

public class StatisticalAnalysis {
    private Iterator <String> iterator;

    public StatisticalAnalysis(Iterator<String> iterator) {
        this.iterator = iterator;
    }

    public Map<String, Integer> countOf(String... elems){
        Map<String, Integer> countOfElements = new HashMap<>();

        for(String element: elems){
            Integer counter = 0;
            while (iterator.hasNext()){
                if(element.equalsIgnoreCase(iterator.next())){
                    ++counter;
                }
            }
            countOfElements.put(element, counter);
        }

        return countOfElements;
    }

    public int dictionarySize(){
        return getDictionary().size();
    }

    private Set<String> getDictionary(){
        Set<String> dictionary = new HashSet<>();

        while (iterator.hasNext()){
            dictionary.add(iterator.next());
        }

        return dictionary;
    }

    public int size(){
        int counter = 0;
        while (iterator.hasNext()){
            iterator.next();
            ++counter;
        }

        return counter;
    }

    public List <String> occurMoreThan(int occurrences){
        List <String> matchingElements = new ArrayList<>();

        for(String element: getDictionary()){
            int counter = 0;
            while (iterator.hasNext()){
                if(element.equalsIgnoreCase(iterator.next())) {
                    ++counter;
                }
                if(counter >= occurrences){
                    matchingElements.add(element);
                    break;
                }
            }
        }
        return matchingElements;

    }
}
