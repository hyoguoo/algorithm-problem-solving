/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14729
 * Cheat Level: 0
 * Algorithm: Sort
 */

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SevenWarlords {

    private static final int LIMIT = 7;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        double[] numbers = new double[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Double.parseDouble(bufferedReader.readLine());
        }

        System.out.print(solution(numbers));
    }

    private static String solution(double[] numbers) {
        StringBuilder result = new StringBuilder();
        Arrays.sort(numbers);

        for (int i = 0; i < LIMIT; i++) {
            result.append(String.format("%.3f", numbers[i])).append("\n");
        }

        return result.toString().trim();
    }
}
