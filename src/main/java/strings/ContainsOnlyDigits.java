package strings;

public class ContainsOnlyDigits {

    public static boolean containsOnlyDigits(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsOnlyDigitsFuntionalStyle(String str) {
        return !str.chars()
                .anyMatch(n -> !Character.isDigit(n));
    }

    public static boolean containsOnlyDigitsRegX(String str) {
        return str.matches("[0-9]+");

    }
}
