/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9461
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PadovanSequence {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < length; i++) list.add(Integer.parseInt(bufferedReader.readLine()));
        long[] dp = new long[100 + 1];
        solution(dp);
        for (Integer integer : list) System.out.println(dp[integer]);
    }

    private static void solution(long[] dp) {
        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;
        for (int i = 6; i <= 100; i++) dp[i] = dp[i - 5] + dp[i - 1];
    }
}
