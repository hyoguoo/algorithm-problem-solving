/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2565
 * Cheat Level: 1
 * Algorithm:
 */

package _test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Wireline {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int wireCount = Integer.parseInt(bufferedReader.readLine());
        Pair[] wires = new Pair[wireCount];

        for (int i = 0; i < wireCount; i++) {
            int[] wireInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            wires[i] = new Pair(wireInfo[0], wireInfo[1]);
        }

        System.out.print(solution(wires));
    }

    private static int solution(Pair[] wires) {
        Arrays.sort(wires, Comparator.comparingInt(a -> a.from));

        int[] dp = new int[wires.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < wires.length; i++) {
            for (int j = 0; j < i; j++) {
                if (wires[i].to > wires[j].to) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return wires.length - Arrays.stream(dp).max().orElseThrow();
    }

    static class Pair {

        private final int from;
        private final int to;

        public Pair(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
}
