package strings;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class CountingDuplicateCharactersTest {

    private static final String STRING_INPUT = "wie geht";
    private static final Map<Character, Integer> expectedResult = Map.of(
            'e', 2,
            'g', 1,
            'i', 1,
            't', 1,
            'w', 1,
            'h', 1,
            ' ', 1

    );

    @Test
    void countingDuplicateCharTest() {
        var actual = CountingDuplicateCharacters.countingDuplicateChar(STRING_INPUT);
        assertThat("Expected value is not equals to actual value",
                actual, is(expectedResult));
    }

    @Test
    void countDuplicateCharactersTest() {
        var actual = CountingDuplicateCharacters.countDuplicateCharacters(STRING_INPUT);
        assertThat("Expected value is not equals to actual value",
                actual, is(expectedResult));
    }
}
