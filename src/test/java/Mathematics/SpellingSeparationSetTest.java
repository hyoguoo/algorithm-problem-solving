package Mathematics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SpellingSeparationSetTest {

    @Test
    void testCase1() {
        String[] inputString = {"g", "o", "o", "r", "m" };

        Assertions.assertEquals(SpellingSeparationSet.solution(inputString), 4);
    }

    @Test
    void testCase2() {
        String[] inputString = {"a", "l", "g", "o", "r", "i", "t", "h", "m" };

        Assertions.assertEquals(SpellingSeparationSet.solution(inputString), 9);
    }
}