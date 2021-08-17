package strings;

import java.util.Arrays;

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

    public static void main(String[] args) {
        String str = "guten abend wie geht est ihnen";
        FirstNonRepeatedChar firstNonRepeatedChar = new FirstNonRepeatedChar();
        var res = firstNonRepeatedChar.firstNonRepeatedChar(str);
        System.out.println("✅ " + res);
    }
}
