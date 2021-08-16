package strings;

import java.util.HashMap;
import java.util.Map;

public class CountingDuplicateCharacters {

    private static final String STRING_INPUT = "Hallo, wie geht es ihnen";

    public static Map<Character, Integer> countingDuplicateChar(String input) {
        Map<Character, Integer> result = new HashMap<>();

        var charSeq = input.toCharArray();

        for (char item :
                charSeq) {
            result.compute(item,
                    (key, value) -> value == null ? 1 : value + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        var data = CountingDuplicateCharacters.countingDuplicateChar(STRING_INPUT);
        System.out.println(data);
    }
}
