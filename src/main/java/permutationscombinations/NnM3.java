/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15651
 * Cheat Level: 0
 * Algorithm: Permutation
 */

package permutationscombinations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NnM3 {

    static final StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] result = new int[input[1]];
        recursion(input[0], input[1], result, 0);
        System.out.println(stringBuilder);
    }

    private static void recursion(int N, int M, int[] result, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) stringBuilder.append(result[i]).append(" ");
            stringBuilder.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            result[depth] = i + 1;
            recursion(N, M, result, depth + 1);
        }
    }
}
