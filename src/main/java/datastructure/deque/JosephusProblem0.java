/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11866
 * Cheat Level: 0
 * Algorithm: Deque
 */

package datastructure.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class JosephusProblem0 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int length = numbers[0];
        int skip = numbers[1];

        JosephusDeque josephusDeque = new JosephusDeque(length);
        List<Integer> result = new ArrayList<>();

        while (josephusDeque.isNotEmpty()) {
            josephusDeque.skipNTimes(skip - 1);
            result.add(josephusDeque.removeFront());
        }

        printResult(result);
    }

    private static void printResult(List<Integer> result) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<");
        for (Integer integer : result) stringBuilder.append(integer).append(", ");
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append(">");
        System.out.println(stringBuilder);
    }
}

class JosephusDeque {
    private final Deque<Integer> deque;

    public JosephusDeque(int length) {
        this.deque = new ArrayDeque<>();
        for (int i = 1; i <= length; i++) this.deque.add(i);
    }

    public int removeFront() {
        return this.deque.removeFirst();
    }

    public void skipNTimes(int skip) {
        for (int i = 0; i < skip; i++) this.deque.add(this.deque.removeFirst());
    }

    public boolean isNotEmpty() {
        return !this.deque.isEmpty();
    }
}
