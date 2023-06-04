/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 7579
 * Cheat Level: 0
 * Algorithm: Dynamic Programming / Knapsack
 */

package dynamicprogramming.knapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class App {

    final static List<Item> ITEM_LIST = new ArrayList<>();
    static int TARGET, N, MAX_COST;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solution());
    }

    private static int solution() {
        int[] dp = new int[MAX_COST + 1];

        for (Item item : ITEM_LIST) {
            for (int i = MAX_COST; i >= item.cost; i--) {
                dp[i] = Math.max(dp[i], dp[i - item.cost] + item.value);
            }
        }

        return getMinCost(TARGET, dp);
    }

    private static int getMinCost(int TARGET, int[] dp) {
        return IntStream.range(0, dp.length).filter(i -> dp[i] >= TARGET).findFirst().orElse(-1);
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        TARGET = info[1];
        int[] values = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] costs = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < N; i++) {
            MAX_COST += costs[i];
            ITEM_LIST.add(new Item(costs[i], values[i]));
        }
    }

    static class Item {

        int cost;
        int value;

        public Item(int cost, int value) {
            this.cost = cost;
            this.value = value;
        }
    }
}
