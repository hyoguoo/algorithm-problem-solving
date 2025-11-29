/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10570
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class FavoriteNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            int numberCount = Integer.parseInt(bufferedReader.readLine());
            int[] numbers = new int[numberCount];
            for (int i = 0; i < numberCount; i++) {
                numbers[i] = Integer.parseInt(bufferedReader.readLine());
            }

            stringBuilder
                    .append(solution(numbers))
                    .append(System.lineSeparator());
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int[] numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet()
                .stream()
                .max(favoriteNumberComparator())
                .orElseThrow()
                .getKey();
    }

    private static Comparator<Entry<Integer, Long>> favoriteNumberComparator() {
        return (e1, e2) -> {
            int countCompare = e1.getValue().compareTo(e2.getValue());
            if (countCompare == 0) {
                return e2.getKey().compareTo(e1.getKey());
            }
            return countCompare;
        };
    }
}
