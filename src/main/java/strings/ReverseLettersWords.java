package strings;

import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReverseLettersWords {
    private static final Pattern PATTERN = Pattern.compile(" +");
    private static final String WHITESPACE = " ";

    public String reverseWord(String str) {
        var words = str.split(WHITESPACE);
        StringBuilder reversedString = new StringBuilder();

        for (var word :
                words) {
            StringBuilder reverseWord = new StringBuilder();
            for (int i = words.length - 1; i >= 0; i--) {
                reverseWord.append(word.charAt(i));
            }
            reversedString.append(reverseWord).append(WHITESPACE);
        }

        return reversedString.toString();
    }

    public String reverseWordsStringBuilder(String str) {
        return new StringBuilder(str)
                .reverse()
                .toString();
    }

    public String reverseWordsFunctionalStyle(String str) {
        return PATTERN.splitAsStream(str)
                .map(w -> new StringBuilder(w).reverse())
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        ReverseLettersWords reverseLettersWords = new ReverseLettersWords();
        System.out.println(reverseLettersWords.reverseWordsStringBuilder("Wie geht est ihnen"));
    }
}
