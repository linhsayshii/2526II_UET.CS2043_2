import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NormalizeText {
    private final String text;
    private Map<String, Integer> wordCount;
    public NormalizeText(String text) {
        this.text = text;
    }
    private void processText() {
        String normalized = text.toLowerCase();
        normalized = normalized.replaceAll("[^a-z\\s]", "");
        String[] words = normalized.split("\\s+");
        
        this.wordCount = new HashMap<>();
        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
    }
    public String getMostCommonWord() {
        if(wordCount == null) {
            processText();
        }
        String mostCommonWord = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommonWord = entry.getKey();
            }
        }
        return mostCommonWord;
    }
    public List<String> getUniqueWords() {
        if(wordCount == null) {
            processText();
        }
        List<String> uniqueWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                uniqueWords.add(entry.getKey());
            }
        }
        return uniqueWords;
    }
}
