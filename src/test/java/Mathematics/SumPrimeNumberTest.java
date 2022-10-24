package Mathematics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumPrimeNumberTest {

    @Test
    void countPrimeNumber() {
        int[] numberArray = {1, 3, 5, 7};
        int length = 4;
        assertEquals(SumPrimeNumber.sumPrimeNumber(numberArray, length), 8);
    }


    @Test
    void isPrime() {
        assertTrue(SumPrimeNumber.isPrime(29));
    }

    @Test
    void isNotPrimeCase1() {
        assertFalse(SumPrimeNumber.isPrime(15));
    }

    @Test
    void isNotPrimeCase2() {
        assertFalse(SumPrimeNumber.isPrime(-3));
    }
}