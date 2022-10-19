package Mathematics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindSuccessfulCandidateTest {

    @Test
    void sum() {
        List<Integer> numberList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int sum = FindSuccessfulCandidate.sum(numberList);

        Assertions.assertEquals(sum, 1 + 2 + 3 + 4 + 5);
    }

    @Test
    void average() {
        List<Integer> numberList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int sum = 1 + 2 + 3 + 4 + 5;

        double listAverage = FindSuccessfulCandidate.average(numberList);
        Assertions.assertEquals(listAverage, sum / numberList.size());
    }
}