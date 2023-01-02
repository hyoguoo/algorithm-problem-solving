/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1874
 * Cheat Level: 0
 * Algorithm: Stack
 */

package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackSequence {

    static final String PLUS = "+\n";
    static final String MINUS = "-\n";


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < length; i++) numbers.add(Integer.parseInt(bufferedReader.readLine()));

        System.out.println(solution(numbers));
    }

    private static String solution(List<Integer> numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        for (Integer number : numbers) {
            if (number > currentNumber) currentNumber = stackNumbers(stringBuilder, stack, currentNumber, number);
            if (!stack.peek().equals(number)) return "NO";
            popNumber(stringBuilder, stack);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return stringBuilder.toString();
    }

    private static void popNumber(StringBuilder stringBuilder, Stack<Integer> stack) {
        stack.pop();
        stringBuilder.append(MINUS);
    }

    private static int stackNumbers(StringBuilder stringBuilder, Stack<Integer> stack, int currentNumber, Integer number) {
        for (int i = currentNumber + 1; i <= number; i++) {
            stack.push(i);
            stringBuilder.append(PLUS);
        }
        currentNumber = number;
        return currentNumber;
    }
}
