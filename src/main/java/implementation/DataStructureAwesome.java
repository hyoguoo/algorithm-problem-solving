/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 23253
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class DataStructureAwesome {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int stackCount = info[1];

        List<Deque<Integer>> stacks = new ArrayList<>();

        for (int i = 0; i < stackCount; i++) {
            bufferedReader.readLine();
            Deque<Integer> stack = Arrays.stream(bufferedReader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toCollection(ArrayDeque::new));

            stacks.add(stack);
        }

        System.out.print(solution(stacks) ? "Yes" : "No");
    }

    private static boolean solution(List<Deque<Integer>> bookStacks) {
        return bookStacks.stream()
                .allMatch(DataStructureAwesome::isSorted);
    }

    private static boolean isSorted(Deque<Integer> stack) {
        int prev = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (current > prev) {
                return false;
            }
            prev = current;
        }
        return true;
    }
}
