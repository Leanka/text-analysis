package application;

import analysis.CharAnalysis;
import analysis.WordAnalysis;
import textIterator.FileContent;
import view.View;

import java.io.FileNotFoundException;
import java.util.Map;

public class ApplicationHelper {
    private FileContent fileContent;
    private CharAnalysis charAnalysis;
    private WordAnalysis wordAnalysis;
    private View view;

    public ApplicationHelper(String fileName) throws FileNotFoundException{
        this.fileContent = new FileContent(fileName);
        this.charAnalysis = new CharAnalysis(fileContent.chariterator());
        this.wordAnalysis = new WordAnalysis((fileContent.worditerator()));
        this.view = new View();
    }

    public void analyseText(){
        textData();
        charCount();
        wordCount();
        dictSize();
        mostUsedWords(1);
        wordsOccurrenceCount("love", "hate", "music");
        vowelsCount();
        lettersRatio("a", "e");
        lettersStatistics();

    }

    private void textData(){
        view.printLine("==" + fileContent.getFilename() + "==");
    }

    private void charCount(){
        view.printMessage("Char count: ");
        view.printLine(charAnalysis.size());
    }

    private void wordCount(){
        view.printMessage("Word count: ");
        view.printLine(wordAnalysis.size());
    }

    private void dictSize(){
        view.printMessage("Dict size: ");
        view.printLine(wordAnalysis.dictionarySize());
    }

    private void mostUsedWords(Integer percent){
        view.printMessage("Most used words (>" + percent + "%): ");
        view.printLine(wordAnalysis.mostUsedWordsByPercen(percent));
    }

    private void wordsOccurrenceCount(String... words){
        Map<String, Integer> wordsOccurrence = wordAnalysis.countOf(words);
        for(Map.Entry<String, Integer> entry: wordsOccurrence.entrySet()){
            view.printMessage(" '" + entry.getKey() + "' count: ");
            view.printLine(entry.getValue());
        }
    }

    private void vowelsCount(){
        view.printMessage("vowels %: ");
        view.printLine(charAnalysis.vowelsPercentage());
    }

    private void lettersRatio(String firstLetter, String secondLetter){
        view.printMessage(firstLetter + ":" + secondLetter + " count ratio: ");
        view.printLine(charAnalysis.vowelsRatio(firstLetter, secondLetter));
    }

    private void lettersStatistics(){
        view.printMap(charAnalysis.getLettersPercentageStatistics());
    }
}
