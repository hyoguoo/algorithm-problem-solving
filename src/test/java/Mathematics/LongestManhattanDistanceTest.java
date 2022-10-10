/*
 * goormlevel
 * https://level.goorm.io
 * Monday Challenge: 1주차 문제 3
 */

package Mathematics;

import Mathematics.LongestManhattanDistance;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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