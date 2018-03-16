package textIterator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.stream.Collectors;

public class FileContent implements IterableText{
    private String fileContent;

    public FileContent(String filePath) throws FileNotFoundException{
        fileContent = getFileContent(filePath);
    }

    private String getFileContent(String filePath) throws FileNotFoundException{
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        return reader
                .lines()
                .collect(Collectors.joining("\n"));
    }

    public Iterator<String> chariterator() {
        return null;
    }

    public Iterator<String> worditerator() {
        return null;
    }

    public String getFileContent() {
        return fileContent;
    }
}
