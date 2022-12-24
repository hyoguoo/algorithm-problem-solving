/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15649
 */

package PermutationsCombinations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NnM1 {

    static final StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

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
                result[depth] = i + 1;
                recursion(N, M, result, visited, depth + 1);
                visited[i] = false;
            }
        }
    }
}
