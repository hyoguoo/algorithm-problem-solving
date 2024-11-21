/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 21967
 * Cheat Level: 0
 * Algorithm: Two Pointer
 */

package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;

public class BuildOnTheRock {

    private static final int DIFF_LIMIT = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(numbers));
    }

    private static int solution(int[] numbers) {
        TreeMap<Integer, Integer> window = new TreeMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < numbers.length; right++) {
            window.put(numbers[right], window.getOrDefault(numbers[right], 0) + 1);

            while (window.lastKey() - window.firstKey() > DIFF_LIMIT) {
                int leftValue = numbers[left];
                window.put(leftValue, window.get(leftValue) - 1);
                if (window.get(leftValue) == 0) {
                    window.remove(leftValue);
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
