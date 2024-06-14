/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 30805
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LexicographicallyLargestCommonSubsequence {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers1 = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        bufferedReader.readLine();
        int[] numbers2 = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(numbers1, numbers2));
    }

    private static String solution(int[] numbers1, int[] numbers2) {
        List<Integer> result = new ArrayList<>();
        int currentIndex1 = 0;
        int currentIndex2 = 0;

        while (currentIndex1 < numbers1.length && currentIndex2 < numbers2.length) {
            Optional<Pair> optionalPair = findMaxCommonValue(numbers1, numbers2, currentIndex1,
                    currentIndex2);
            if (optionalPair.isPresent()) {
                Pair pair = optionalPair.get();
                result.add(pair.value);
                currentIndex1 = pair.index1 + 1;
                currentIndex2 = pair.index2 + 1;
            } else {
                break;
            }
        }

        return resultToString(result);
    }

    private static Optional<Pair> findMaxCommonValue(
            int[] numbers1,
            int[] numbers2,
            int startIndex1,
            int startIndex2
    ) {
        int maxValueIndex1 = startIndex1;
        int maxValueIndex2 = startIndex2;
        int maxValue = Integer.MIN_VALUE;

        for (int i = startIndex1; i < numbers1.length; i++) {
            for (int j = startIndex2; j < numbers2.length; j++) {
                if (numbers1[i] == numbers2[j] && numbers1[i] > maxValue) {
                    maxValueIndex1 = i;
                    maxValueIndex2 = j;
                    maxValue = numbers1[i];
                    break;
                }
            }
        }

        return maxValue == Integer.MIN_VALUE
                ? Optional.empty()
                : Optional.of(new Pair(maxValueIndex1, maxValueIndex2, maxValue));
    }

    private static String resultToString(List<Integer> result) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(result.size()).append("\n");
        result.forEach(value -> stringBuilder.append(value).append(" "));

        return stringBuilder.toString().trim();
    }

    static class Pair {

        private final int index1;
        private final int index2;
        private final int value;

        public Pair(int index1, int index2, int value) {
            this.index1 = index1;
            this.index2 = index2;
            this.value = value;
        }
    }
}
