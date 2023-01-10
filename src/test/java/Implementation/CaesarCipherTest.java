package Implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaesarCipherTest {

    @Test
    void offsetCharCase1() {
        char result = CaesarCipher.offsetChar('M', 3);

        assertEquals(result, 'J');
    }

    @Test
    void offsetCharCase2() {
        char result = CaesarCipher.offsetChar('A', 3);

        assertEquals(result, 'X');
    }
}