/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 12865
 * Cheat Level: 4
 * Algorithm: Dynamic Programming / Knapsack
 */

package dynamicprogramming.knapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NormalKnapsack {

    final static List<Item> itemList = new ArrayList<>();
    static int target;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int length = info[0];
        target = info[1];
        dp = new int[target + 1];

        for (int i = 0; i < length; i++) {
            int[] itemInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            itemList.add(new Item(itemInfo[0], itemInfo[1]));
        }

        solution();
        System.out.println(dp[target]);
    }

    private static void solution() {
        for (Item item : itemList) {
            for (int i = target; i >= item.weight; i--) {
                dp[i] = Math.max(dp[i], dp[i - item.weight] + item.value);
            }
        }
    }
}

class Item {

    int weight;
    int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}
