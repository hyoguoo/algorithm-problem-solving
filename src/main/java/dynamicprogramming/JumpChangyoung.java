/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 22114
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JumpChangyoung {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int stride = info[1];
        int[] distances = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(distances, stride));
    }

    private static int solution(int[] distances, int stride) {
        int n = distances.length + 1;
        int[][] dp = new int[n + 1][2];

        dp[1][0] = 1;
        dp[1][1] = 1;
        int max = 1;

        for (int i = 2; i <= n; i++) {
            int dist = distances[i - 2];
            if (dist <= stride) {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1] + 1;
            } else {
                dp[i][0] = 1;
                dp[i][1] = dp[i - 1][0] + 1;
            }
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }

        return max;
    }
}
