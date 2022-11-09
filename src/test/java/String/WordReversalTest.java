package String;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordReversalTest {

    @Test
    void solution() {
        String input = "I am happy today";
        String result = "I ma yppah yadot";
        assertEquals(result, WordReversal.solution(input).toString());
    }

    @Test
    void reverse() {
        String input = "Hello";
        String expected = "olleH";
        String actual =  WordReversal.reverse(input).toString();
        assertEquals(expected, actual);
    }

}