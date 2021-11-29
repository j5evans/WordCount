package bsu.comp152;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        var wordMap = new HashMap<String, Integer>();
        var filePath = Paths.get("warpeace.txt");
        List<String> fileText = null;
        try {
            fileText = Files.readAllLines(filePath);
        }
        catch (IOException e) {
            System.out.println("Error reading file.");
        }
        if (fileText == null)
            System.exit(-1);

        for (var line : fileText) {
            var splitLine = line.split(" ");
            for (var word : splitLine) {
                var lowerCaseWord = word.toLowerCase(Locale.ROOT);
                if (wordMap.containsKey(lowerCaseWord)) {
                    var currentCount = wordMap.get(lowerCaseWord);
                    wordMap.replace(lowerCaseWord, ++currentCount);
                }
                else {
                    wordMap.put(lowerCaseWord, 1);
                }
            }
        }
        var keys = wordMap.keySet();
        for (var key : keys) {
            System.out.println(key + ": " + wordMap.get(key));
        }
    }
}
