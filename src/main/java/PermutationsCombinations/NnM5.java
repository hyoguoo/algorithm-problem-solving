/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15654
 * Cheat Level: 0
 * Algorithm: Permutation
 */

package PermutationsCombinations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NnM5 {

    static final StringBuilder stringBuilder = new StringBuilder();
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numbers);

        int[] result = new int[input[1]];
        boolean[] visited = new boolean[input[0]];
        recursion(input[0], input[1], result, visited, 0);
        System.out.println(stringBuilder);
    }

    private static void recursion(int N, int M, int[] result, boolean[] visited, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) stringBuilder.append(result[i]).append(" ");
            stringBuilder.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = numbers[i];
                recursion(N, M, result, visited, depth + 1);
                visited[i] = false;
            }
        }
    }
}
