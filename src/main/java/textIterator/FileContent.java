package textIterator;

import iterator.Chariterator;
import iterator.Worditerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class FileContent implements IterableText{
    private String fileContent;
    private String filename;

    public FileContent(String filename) throws FileNotFoundException{
        this.filename = filename;
        this.fileContent = getFileContent();
        validateFileContent();
    }

    private String getFileContent() throws FileNotFoundException{

        File file = getFile();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        return reader
                .lines()
                .map(String::toUpperCase)
                .map(line -> line.replaceAll("[^A-Z ]", ""))
                .collect(Collectors.joining(" ")).trim();
    }
    private File getFile() throws FileNotFoundException{
        String filePath = System.getProperty("user.dir") + "/src/main/resources/" + filename;
        File file = new File(filePath);

        if(!file.isFile()){
            throw new FileNotFoundException("File not found!");
        }else if(file.length() == 0){
            throw new FileNotFoundException("File found, but it's empty!");
        }
        return file;
    }

    private void validateFileContent() throws FileNotFoundException{
        if(fileContent.trim().isEmpty()){
            throw new FileNotFoundException("File is empty!");
        }
    }

    public Iterator<String> chariterator() {
        return new Chariterator(asList(fileContent.split("")));    }

    public Iterator<String> worditerator() {
        return new Worditerator(asList(fileContent.split("[ ]+")));
    }

    public String getFilename() {
        return filename;
    }
}
