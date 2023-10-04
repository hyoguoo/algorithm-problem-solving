/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17298
 * Cheat Level: 0
 * Algorithm: Stack
 */

package datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NGE {

    static final int NOT_EXIST = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(printResult(solution(numbers)));
    }

    private static List<Integer> solution(int[] numbers) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        result.add(NOT_EXIST);
        stack.push(numbers[numbers.length - 1]);

        for (int i = numbers.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= numbers[i]) stack.pop();
            if (!stack.isEmpty()) result.add(stack.peek());
            else result.add(NOT_EXIST);
            stack.push(numbers[i]);
        }
        return result;
    }

    private static String printResult(List<Integer> result) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = result.size() - 1; i >= 0; i--) {
            stringBuilder.append(result.get(i)).append(" ");
        }
        return stringBuilder.toString();
    }
}
