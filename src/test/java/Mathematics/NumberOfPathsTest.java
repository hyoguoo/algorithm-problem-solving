package Mathematics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfPathsTest {

    @Test
    void getPaths() {
        int[] numberArray = {153, 343, 677, 30};
        int length = 4;
        assertEquals(NumberOfPaths.getPaths(length, numberArray), 1065848490);
    }
}