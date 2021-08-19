package strings;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedChar {

    private static final int EXTENDED_ASCII_CODES = 256;

    public char firstNonRepeatedChar(String input) {

        int[] flags = new int[EXTENDED_ASCII_CODES];
        Arrays.fill(flags, -1);

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (flags[ch] == -1) {
                flags[ch] = i;
            } else {
                flags[ch] = -2;
            }
        }
        int position = Integer.MAX_VALUE;
        for (int i = 0; i < EXTENDED_ASCII_CODES; i++) {
            if (flags[i] >= 0) {
                position = Math.min(position, flags[i]);
            }
        }
        return position == Integer.MAX_VALUE ? Character.MIN_VALUE : input.charAt(position);
    }

    public char firstNonRepeatedCharLinkedList(String str) {
        Map<Character, Integer> chars = new LinkedHashMap<>();

        // Add string chars into LinkedHashMap
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            chars.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }

        // return the first char key where value equals 1
        for (Map.Entry<Character, Integer> entry :
                chars.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return Character.MIN_VALUE;
    }

    public String firstNonRepeatedCharLinkedListFuntionalStyle(String str) {
        Map<Integer, Long> chs = str.codePoints()
                .mapToObj(cp -> cp)
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, Collectors.counting()));
        int cp = chs.entrySet().stream()
                .filter(e -> e.getValue() == 1L)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse((int) Character.MIN_VALUE);

        return String.valueOf(Character.toChars(cp));

    }

    public static void main(String[] args) {
        String str = "guten abend wie geht est ihnen";
        FirstNonRepeatedChar firstNonRepeatedChar = new FirstNonRepeatedChar();
        var res = firstNonRepeatedChar.firstNonRepeatedChar(str);
        System.out.println("✅ " + res);

        var linkedListResult = firstNonRepeatedChar.firstNonRepeatedCharLinkedList(str);
        System.out.println("✅ " + linkedListResult);

        var functionalStyleResult = firstNonRepeatedChar.firstNonRepeatedCharLinkedListFuntionalStyle(str);
        System.out.println("✅ " + functionalStyleResult);
    }
}
