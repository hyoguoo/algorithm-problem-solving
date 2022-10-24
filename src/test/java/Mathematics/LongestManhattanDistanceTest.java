
package Mathematics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestManhattanDistanceTest {

    @Test
    void getManhattanDistanceCase1() {
        int[] numberArray = {-10, -3, -1, 5};
        assertEquals(LongestManhattanDistance.getManhattanDistance(numberArray), 17);
    }

    @Test
    void getManhattanDistanceCase2() {
        int[] numberArray = {1, 3, 7, 12};
        assertEquals(LongestManhattanDistance.getManhattanDistance(numberArray), 15);
    }
}