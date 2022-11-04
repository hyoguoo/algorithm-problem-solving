/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2812
 */

package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Stack;

class MakeBiggerTest {

    @BeforeEach
    void beforeEach() {
        MakeBigger.stack = new Stack<>();
    }

    @Test
    void concatenateStackToString() {
        MakeBigger.stack.push(5);
        MakeBigger.stack.push(9);
        Assertions.assertEquals(MakeBigger.concatenateStackToString(MakeBigger.stack), "59");
    }

    @Test
    void popStackNTimes() {
        MakeBigger.stack.push(5);
        MakeBigger.stack.push(9);
        MakeBigger.stack.push(1);
        MakeBigger.stack.push(2);
        MakeBigger.popStackNTimes(2);
        Assertions.assertEquals(MakeBigger.concatenateStackToString(MakeBigger.stack), "59");
    }

    @Test
    void makeBiggerNumberToStackCase1() {
        int[] numberArray = {1, 2, 3, 1, 2, 3, 4};
        MakeBigger.makeBiggerNumberToStack(numberArray, 3);
        Assertions.assertEquals(MakeBigger.concatenateStackToString(MakeBigger.stack), "3234");
    }

    @Test
    void makeBiggerNumberToStackCase2() {
        int[] numberArray = {7, 8, 9, 8, 1, 1, 1, 1, 0, 1};
        MakeBigger.makeBiggerNumberToStack(numberArray, 4);
        Assertions.assertEquals(MakeBigger.concatenateStackToString(MakeBigger.stack), "981111");
    }

    @Test
    void getBiggerStack() {
        int[] numberArray = {7, 8, 9, 8, 1, 1, 1, 1, 0, 1};
        int count = MakeBigger.getBiggerStack(numberArray, 4);
        Assertions.assertEquals(count, 1);
    }

}