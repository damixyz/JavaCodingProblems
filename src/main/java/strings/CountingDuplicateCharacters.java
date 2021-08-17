package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountingDuplicateCharacters {

    // Independent solution
    public static Map<Character, Integer> countingDuplicateChar(String str) {
        Map<Character, Integer> result = new HashMap<>();

        var charSeq = str.toCharArray();

        for (char item :
                charSeq) {
            result.compute(item,
                    (key, value) -> value == null ? 1 : value + 1);
        }
        return result;
    }

    public static Map<Character, Integer> countDuplicateCharacters(String str) {
        Map<Character, Integer> result = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }
        return result;
    }

    private Map<Character, Long> countDuplicateStreams(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }

    private Map<String, Integer> countDuplicateASCIILoop(String str) {
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            int cp = str.codePointAt(i);
            String ch = String.valueOf(Character.toChars(cp));
            if (Character.charCount(cp) == 2) {
                // 2 means a surrogate pair
                i++;
            }
            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }
        return result;
    }

    private Map<String, Long> countDuplicateASCIIStream(String str) {
        return str.codePoints().mapToObj(c -> String.valueOf(Character.toChars(c)))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }
}
