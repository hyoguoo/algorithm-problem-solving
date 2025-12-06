/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 18511
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BuildingLargeNumbers {

    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int maxNumber = info[0];
        int[] availableNumbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(availableNumbers, maxNumber));
    }

    private static int solution(int[] availableNumbers, int maxNumber) {
        int[] sortedAvailableNumbers = Arrays.stream(availableNumbers)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        answer = 0;
        dfs(0, 0, sortedAvailableNumbers, maxNumber, String.valueOf(maxNumber).length());

        return answer;
    }

    private static void dfs(int current, int depth, int[] nums, int limit, int maxLen) {
        if (depth > 0) {
            if (current <= limit) {
                answer = Math.max(answer, current);
            } else {
                return;
            }
        }

        if (depth == maxLen) {
            return;
        }

        for (int d : nums) {
            int next = current * 10 + d;
            dfs(next, depth + 1, nums, limit, maxLen);
        }
    }
}
