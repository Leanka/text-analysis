package view;

import java.util.List;
import java.util.Map;

public class View {

    public <T> void printLine(T message){
        System.out.println(String.valueOf(message));
    }

    public <T> void printMessage(T message){
        System.out.print(String.valueOf(message));
    }

    public <K, V> void printMap(Map<K, V> dictionary){
        for (Map.Entry<K, V> entry: dictionary.entrySet()){
            printMessage("[" + entry.getKey() + " -> " + entry.getValue() + "] ");
        }
        printLine("");
    }

}
