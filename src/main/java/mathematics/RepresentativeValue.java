/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2592
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

public class RepresentativeValue {

    private static final int NUMBER_COUNT = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[NUMBER_COUNT];

        for (int i = 0; i < NUMBER_COUNT; i++) {
            numbers[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(solution(numbers));
    }

    private static String solution(int[] numbers) {
        double mean = calculateMean(numbers);
        Map<Integer, Integer> numberCount = countNumber(numbers);

        return String.format("%.0f", mean) + "\n" + findMostFrequentNumber(numberCount);
    }

    private static double calculateMean(int[] numbers) {
        return Arrays.stream(numbers).average().orElse(0);
    }

    private static Map<Integer, Integer> countNumber(int[] numbers) {
        return Arrays.stream(numbers).boxed()
                .collect(java.util.stream.Collectors.toMap(k -> k, v -> 1, Integer::sum));
    }

    private static int findMostFrequentNumber(Map<Integer, Integer> numberCount) {
        return numberCount.entrySet().stream()
                .max(java.util.Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(0);
    }
}
