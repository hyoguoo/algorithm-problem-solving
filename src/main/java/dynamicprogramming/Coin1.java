/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2293
 * Cheat Level: 2
 * Algorithm: Dynamic Programming
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coin1 {

    final static List<Integer> coinList = new ArrayList<>();
    static int[] dp;
    static int N;
    static int TARGET;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        TARGET = info[1];
        for (int i = 0; i < N; i++) coinList.add(Integer.parseInt(bufferedReader.readLine()));
        dp = new int[TARGET + 1];

        solution();
        System.out.println(dp[TARGET]);
    }

    private static void solution() {
        dp[0] = 1;
        for (Integer coin : coinList) {
            for (int i = 0; i <= TARGET; i++) {
                if (i + coin <= TARGET) dp[i + coin] += dp[i];
            }
        }
    }
}
