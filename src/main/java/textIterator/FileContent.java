package textIterator;

import iterator.Chariterator;
import iterator.Worditerator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class FileContent implements IterableText{
    private String fileContent;

    public FileContent(String filePath) throws FileNotFoundException{
        fileContent = getFileContent(filePath);
    }

    private String getFileContent(String filePath) throws FileNotFoundException{
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        return reader
                .lines()
                .map(String::toUpperCase)
                .map(line -> line.replaceAll("[^A-Z ]", ""))
                .collect(Collectors.joining(" "));
    }

    public Iterator<String> chariterator() {
        return new Chariterator(asList(fileContent.split("")));    }

    public Iterator<String> worditerator() {
        return new Worditerator(asList(fileContent.split("[ ]+")));
    }

}
