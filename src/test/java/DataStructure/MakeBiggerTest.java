/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2812
 */

package DataStructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Stack;

class MakeBiggerTest {
    MakeBigger makeBigger = new MakeBigger();

    @BeforeEach
    void beforeEach() {
        MakeBigger.stack = new Stack<>();
    }

    @Test
    void concatenateStackToString() {
        makeBigger.stack.push(5);
        makeBigger.stack.push(9);
        Assertions.assertEquals(MakeBigger.concatenateStackToString(MakeBigger.stack), "59");
    }

    @Test
    void popStackNTimes() {
        makeBigger.stack.push(5);
        makeBigger.stack.push(9);
        makeBigger.stack.push(1);
        makeBigger.stack.push(2);
        makeBigger.popStackNTimes(2);
        Assertions.assertEquals(MakeBigger.concatenateStackToString(makeBigger.stack), "59");
    }

    @Test
    void makeBiggerNumberToStackCase1() {
        int[] numberArray = {1, 2, 3, 1, 2, 3, 4};
        makeBigger.makeBiggerNumberToStack(numberArray, 3);
        Assertions.assertEquals(MakeBigger.concatenateStackToString(makeBigger.stack), "3234");
    }

    @Test
    void makeBiggerNumberToStackCase2() {
        int[] numberArray = {7, 8, 9, 8, 1, 1, 1, 1, 0, 1};
        makeBigger.makeBiggerNumberToStack(numberArray, 4);
        Assertions.assertEquals(MakeBigger.concatenateStackToString(makeBigger.stack), "981111");
    }

    @Test
    void getBiggerStack() {
        int[] numberArray = {7, 8, 9, 8, 1, 1, 1, 1, 0, 1};
        int count = makeBigger.getBiggerStack(numberArray, 4);
        Assertions.assertEquals(count, 1);
    }

}