package application;

import view.View;

import java.io.FileNotFoundException;

public class Application {
    private static View view = new View();

    public static void main(String[] args) {
        ApplicationHelper applicationHelper;
        long startTime = System.nanoTime();
        for(String arg: args){
            try {
                applicationHelper = new ApplicationHelper(arg);
                applicationHelper.analyseText();
            } catch (FileNotFoundException e) {
                view.printLine(arg + ": " + e.getMessage());
            }
            view.printLine("\n"); //separator
        }
        double totalTimeInSeconsd = (System.nanoTime() - startTime)/1000000000d;
        view.printLine("Benchmark time: " + totalTimeInSeconsd + " secs");
    }
}
