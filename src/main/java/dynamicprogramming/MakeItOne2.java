/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 12852
 * Cheat Level: 0
 * Algorithm: Dynamic Programming / Graph
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MakeItOne2 {

    static int N;
    static Progress[] dp;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        printResult();
    }

    private static void solution() {
        for (int i = 2; i <= N; i++) {
            if (i % 2 == 0) {
                int count = dp[i / 2].count + 1;
                if (count < dp[i].count) {
                    dp[i].count = count;
                    dp[i].list = new ArrayList<>(dp[i / 2].list);
                    dp[i].list.add(i);
                }
            }
            if (i % 3 == 0) {
                int count = dp[i / 3].count + 1;
                if (count < dp[i].count) {
                    dp[i].count = count;
                    dp[i].list = new ArrayList<>(dp[i / 3].list);
                    dp[i].list.add(i);
                }
            }
            int count = dp[i - 1].count + 1;
            if (count < dp[i].count) {
                dp[i].count = count;
                dp[i].list = new ArrayList<>(dp[i - 1].list);
                dp[i].list.add(i);
            }
        }
    }

    private static void printResult() {
        System.out.println(dp[N].count);
        dp[N].list.stream().sorted(Comparator.reverseOrder()).forEach(e -> System.out.print(e + " "));
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());

        dp = new Progress[N + 1];
        for (int i = 0; i <= N; i++) dp[i] = new Progress(Integer.MAX_VALUE);
        dp[1].count = 0;
        dp[1].list.add(1);
    }

    static class Progress {
        int count;
        List<Integer> list = new ArrayList<>();

        public Progress(int count) {
            this.count = count;
        }
    }
}
