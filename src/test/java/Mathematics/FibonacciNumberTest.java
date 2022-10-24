package Mathematics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciNumberTest {

    @Test
    void getFibonacci() {
        assertEquals(FibonacciNumber.getFibonacci(10), 55);
    }
}