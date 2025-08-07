/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 26595
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GodOfWar {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int totalMoney = Integer.parseInt(bufferedReader.readLine());
        int[] mercenariesInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Mercenary tanker = new Mercenary(mercenariesInfo[0], mercenariesInfo[1]);
        Mercenary dealer = new Mercenary(mercenariesInfo[2], mercenariesInfo[3]);

        System.out.print(solution(totalMoney, tanker, dealer));
    }

    private static Count solution(int totalMoney, Mercenary tanker, Mercenary dealer) {
        Count maxCount = new Count(0, 0);

        for (int tankerCount = 0; tankerCount <= totalMoney / tanker.price; tankerCount++) {
            int remainingMoney = totalMoney - tankerCount * tanker.price;
            int dealerCount = remainingMoney / dealer.price;

            Count currentCount = new Count(tankerCount, dealerCount);
            if (currentCount.calculateDamage(tanker, dealer) > maxCount.calculateDamage(tanker, dealer)) {
                maxCount = currentCount;
            }
        }

        return maxCount;
    }

    static class Mercenary {

        private final int damage;
        private final int price;

        public Mercenary(int damage, int price) {
            this.damage = damage;
            this.price = price;
        }
    }

    static class Count {

        private final long tankerCount;
        private final long dealerCount;

        public Count(int tankerCount, int dealerCount) {
            this.tankerCount = tankerCount;
            this.dealerCount = dealerCount;
        }

        public long calculateDamage(Mercenary tanker, Mercenary dealer) {
            return tankerCount * tanker.damage + dealerCount * dealer.damage;
        }

        @Override
        public String toString() {
            return tankerCount + " " + dealerCount;
        }
    }
}
