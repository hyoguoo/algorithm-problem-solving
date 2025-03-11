/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 12789
 * Cheat Level: 0
 * Algorithm: Stack
 */

package datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DokidokiSnacksDreamy {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(numbers) ? "Nice" : "Sad");
    }

    private static boolean solution(int[] numbers) {
        int currentNumber = 1;
        int index = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        while (index < numbers.length) {
            int number = numbers[index++];
            if (number == currentNumber) {
                currentNumber++;
            } else  {
                stack.push(number);
            }

            while (!stack.isEmpty()) {
                if (stack.peek() == currentNumber) {
                    stack.pop();
                    currentNumber++;
                } else {
                    break;
                }
            }
        }

        while (!stack.isEmpty()) {
            if (stack.pop() != currentNumber++) {
                return false;
            }
        }

        return true;
    }
}
