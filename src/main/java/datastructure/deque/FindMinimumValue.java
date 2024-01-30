/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11003
 * Cheat Level: 0
 * Algorithm: Deque
 */

package datastructure.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class FindMinimumValue {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int range = info[1];
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        solution(numbers, range);
    }

    private static void solution(int[] numbers, int range) {
        Deque<Pair> deque = new ArrayDeque<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < range; i++) {
            while (!deque.isEmpty() && deque.peekLast().value >= numbers[i]) deque.pollLast();
            deque.add(new Pair(i, numbers[i]));
            stringBuilder.append(deque.peekFirst().value).append(" ");
        }

        for (int i = range; i < numbers.length; i++) {
            if (deque.peekFirst().index <= i - range) deque.pollFirst();
            while (!deque.isEmpty() && deque.peekLast().value >= numbers[i]) deque.pollLast();
            deque.add(new Pair(i, numbers[i]));
            stringBuilder.append(deque.peekFirst().value).append(" ");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    static class Pair {
        int index;
        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
