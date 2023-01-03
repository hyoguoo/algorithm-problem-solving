/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9095
 * Cheat Level: 0
 * Algorithm: Dynamic Programming
 */

package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Adding1s2sAnd3s {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) list.add(Integer.parseInt(bufferedReader.readLine()));
        int max = Collections.max(list);

        int[] dp = new int[max + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= max; i++) dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        for (Integer integer : list) System.out.println(dp[integer]);
    }
}
