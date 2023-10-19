/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10974
 * Cheat Level: 0
 * Algorithm: Permutation
 */

package permutationscombinations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AllPermutations {

    static final List<int[]> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        solution(Integer.parseInt(bufferedReader.readLine()));
        printResult();
    }

    private static void solution(int n) {
        permutation(new int[n], new boolean[n + 1], 0);
    }

    private static void permutation(int[] numbers, boolean[] visited, int count) {
        if (count == numbers.length) {
            result.add(numbers.clone());
            return;
        }

        for (int i = 1; i <= numbers.length; i++) {
            if (visited[i]) continue;
            numbers[count] = i;
            visited[i] = true;
            permutation(numbers, visited, count + 1);
            visited[i] = false;
        }
    }

    private static void printResult() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] numbers : result) {
            for (int number : numbers) {
                stringBuilder.append(number).append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }
}
