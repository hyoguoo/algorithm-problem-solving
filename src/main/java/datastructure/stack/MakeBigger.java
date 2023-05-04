/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2812
 * Cheat Level: 2
 * Algorithm: Stack / Greedy
 */

package datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class MakeBigger {

    public static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        int count = info[1];

        solution(numbers, count);
        System.out.println(concatenateStackToString(stack));
    }

    public static void solution(int[] numbers, int count) {
        int remainCount = popSmallNumber(numbers, count);
        popStackNTimes(remainCount);
    }

    public static void popStackNTimes(int count) {
        while (count-- > 0) stack.pop();
    }

    public static int popSmallNumber(int[] numbers, int count) {
        for (int value : numbers) {
            while (!stack.isEmpty() && count > 0 && stack.peek() < value) {
                stack.pop();
                count--;
            }
            stack.push(value);
        }
        return count;
    }

    public static String concatenateStackToString(Stack<Integer> stack) {
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) stringBuilder.append(stack.pop());
        return stringBuilder.reverse().toString();
    }
}
