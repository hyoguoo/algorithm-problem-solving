/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 26267
 * Cheat Level: 0
 * Algorithm: Map
 */

package datastructure.mapset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BankRobber1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int bankCount = Integer.parseInt(bufferedReader.readLine());

        Bank[] banks = new Bank[bankCount];

        for (int i = 0; i < bankCount; i++) {
            int[] bankInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            banks[i] = new Bank(bankInfo[0], bankInfo[1], bankInfo[2]);
        }

        System.out.print(solution(banks));
    }

    private static long solution(Bank[] banks) {
        Map<Integer, Long> map = new HashMap<>();

        for (Bank bank : banks) {
            int key = bank.openTime - bank.position;
            map.put(key, map.getOrDefault(key, 0L) + bank.money);
        }

        return map.values()
                .stream()
                .max(Long::compareTo)
                .orElse(0L);
    }

    static class Bank {

        private final int position;
        private final int openTime;
        private final int money;

        public Bank(int position, int openTime, int money) {
            this.position = position;
            this.openTime = openTime;
            this.money = money;
        }
    }
}
