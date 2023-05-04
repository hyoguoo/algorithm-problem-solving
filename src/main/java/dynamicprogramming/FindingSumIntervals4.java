/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11659
 * Cheat Level: 0
 * Algorithm: Dynamic Programming / Prefix Sum
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindingSumIntervals4 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int resultLength = info[1];
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] accumulate = getAccumulate(numbers);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < resultLength; i++) {
            int[] indexList = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int result = getIntervalSum(accumulate, indexList);
            stringBuilder.append(result).append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static int getIntervalSum(int[] accumulate, int[] indexList) {
        int startIndex = indexList[0];
        int endIndex = indexList[1];
        return accumulate[endIndex] - accumulate[startIndex - 1];
    }

    private static int[] getAccumulate(int[] numbers) {
        int[] accumulate = new int[numbers.length + 1];
        for (int i = 1; i < accumulate.length; i++) accumulate[i] = accumulate[i - 1] + numbers[i - 1];
        return accumulate;
    }
}
