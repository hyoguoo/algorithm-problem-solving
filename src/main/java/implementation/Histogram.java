/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 13752
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Histogram {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int histogramCount = Integer.parseInt(bufferedReader.readLine());
        int[] histogramHeights = new int[histogramCount];

        for (int i = 0; i < histogramCount; i++) {
            histogramHeights[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(solution(histogramHeights));
    }

    private static String solution(int[] histogramHeights) {
        return Arrays.stream(histogramHeights)
                .mapToObj("="::repeat)
                .collect(Collectors.joining("\n"));
    }
}
