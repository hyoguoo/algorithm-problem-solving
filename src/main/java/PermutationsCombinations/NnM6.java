/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15650
 */

package PermutationsCombinations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NnM6 {

    static final StringBuilder stringBuilder = new StringBuilder();
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numbers);

        int[] result = new int[input[1]];
        recursion(input[0], input[1], result, 0, 0);
        System.out.println(stringBuilder);
    }

    private static void recursion(int N, int M, int[] result, int depth, int index) {
        if (depth == M) {
            for (int i = 0; i < M; i++) stringBuilder.append(result[i]).append(" ");
            stringBuilder.append("\n");
            return;
        }

        for (int i = index; i < N; i++) {
            result[depth] = numbers[i];
            recursion(N, M, result, depth + 1, i + 1);
        }
    }
}
