/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9742
 * Cheat Level: 0
 * Algorithm: Permutation / Backtracking
 */

package permutationscombinations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Permutations {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            String input = bufferedReader.readLine();
            if (input == null || input.isEmpty()) {
                break;
            }
            String[] inputInfo = input.split(" ");
            String str = inputInfo[0];
            int order = Integer.parseInt(inputInfo[1]);

            stringBuilder.append(String.format("%s %d = ", str, order))
                    .append(solution(str, order))
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static String solution(String str, int order) {
        char[] chars = str.toCharArray();
        int length = chars.length;
        boolean[] visited = new boolean[length];
        StringBuilder result = new StringBuilder();
        Counter count = new Counter();

        generatePermutations(chars, visited, new StringBuilder(), result, order, count);

        return result.length() > 0 ? result.toString() : "No permutation";
    }

    private static void generatePermutations(char[] chars,
            boolean[] visited,
            StringBuilder current,
            StringBuilder result,
            int order,
            Counter count) {
        if (current.length() == chars.length) {
            if (count.incrementAndGet() == order) {
                result.append(current);
            }
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                current.append(chars[i]);
                generatePermutations(chars, visited, current, result, order, count);
                current.deleteCharAt(current.length() - 1);
                visited[i] = false;
            }
        }
    }

    static class Counter {

        private int value = 0;

        public int incrementAndGet() {
            return ++value;
        }
    }
}
