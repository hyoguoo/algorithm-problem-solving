package Mathematics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindPrimeNumberTest {

    @Test
    void countPrimeNumber() {
        int[] numberArray = {1, 3, 5, 7};
        int length = 4;
        assertEquals(FindPrimeNumber.countPrimeNumber(numberArray, length), 3);
    }


    @Test
    void isPrime() {
        assertTrue(FindPrimeNumber.isPrime(19));
    }

    @Test
    void isNotPrime() {
        assertFalse(FindPrimeNumber.isPrime(9));
    }
}