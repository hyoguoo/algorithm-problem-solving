package Mathematics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SameRemainderTest {

    @Test
    void solution() {
        List<Integer> inputList = new ArrayList<>(List.of(6, 34, 38));
        String result = SameRemainder.solution(inputList);
        System.out.println(result);
        Assertions.assertEquals("2 4", result);
    }

    @Test
    void getMinNumberFromList() {
        List<Integer> numberList = new ArrayList<>(List.of(4, 2, 3, 5, 1));
        int removedNumber = SameRemainder.getMinNumberFromList(numberList);

        Assertions.assertEquals(removedNumber, 1);
    }

    @Test
    void getReducedList() {
        List<Integer> numberList = new ArrayList<>(List.of(4, 2, 3, 5));
        List<Integer> reducedList = SameRemainder.getReducedList(numberList, 1);

        Assertions.assertEquals(reducedList, new ArrayList<>(List.of(3, 1, 2, 4)));
    }

    @Test
    void getGcdInArray() {
        List<Integer> numberList = new ArrayList<>(List.of(12, 18, 9, 78));
        int gcd = SameRemainder.getGcdInArray(numberList, 0, numberList.size());

        Assertions.assertEquals(gcd, 3);
    }

    @Test
    void getGcd() {
        int gcd = SameRemainder.getGcd(32, 36);

        Assertions.assertEquals(gcd, 4);
    }

    @Test
    void getDivisorList() {
        List<Integer> divisorList = new ArrayList<>(List.of(2, 3, 5, 6, 10, 15, 30));

        Assertions.assertEquals(SameRemainder.getDivisorList(30), divisorList);
    }
}