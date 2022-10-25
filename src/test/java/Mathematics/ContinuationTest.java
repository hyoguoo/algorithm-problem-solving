package Mathematics;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContinuationTest {

    @Test
    void convertIntToArray() {
        int number = 234;
        int[] array = {2, 3, 4};

        assertEquals(Arrays.toString(Continuation.intToArray(number)), Arrays.toString(array));
    }

    @Test
    void getMultiplyNumber() {
        int[] number = {2, 3, 4};

        assertEquals(Continuation.getMultiplyNumbers(number), 24);
    }

}