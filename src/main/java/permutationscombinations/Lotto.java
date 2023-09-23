/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 6603
 * Cheat Level: 0
 * Algorithm: Combinations
 */

package permutationscombinations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lotto {

    final static StringBuilder stringBuilder = new StringBuilder();
    final static int LIMIT = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (info[0] == 0) break;
            int[] numbers = Arrays.copyOfRange(info, 1, info.length);
            solution(numbers);
        }
        System.out.print(stringBuilder);
    }

    private static void solution(int[] numbers) {
        recursion(numbers, 0, new int[6], 0);
        stringBuilder.append("\n");
    }

    private static void recursion(int[] numbers, int index, int[] result, int depth) {
        if (depth == LIMIT) {
            for (int i = 0; i < LIMIT; i++) stringBuilder.append(result[i]).append(" ");
            stringBuilder.append("\n");
            return;
        }

        for (int i = index; i < numbers.length; i++) {
            result[depth] = numbers[i];
            recursion(numbers, i + 1, result, depth + 1);
        }
    }
}
