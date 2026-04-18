/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 25238
 * Cheat Level: 0
 * Algorithm: Implementation / Mathematics
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GahiAndDefensePenetration {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(bufferedReader.readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        MonsterInfo monsterInfo = new MonsterInfo(input[0], input[1]);

        System.out.print(solution(monsterInfo).getValue());
    }

    private static DamageAvailability solution(MonsterInfo monsterInfo) {
        return monsterInfo.canReceiveDamage()
                ? DamageAvailability.AVAILABLE
                : DamageAvailability.UNAVAILABLE;
    }

    enum DamageAvailability {
        AVAILABLE(1),
        UNAVAILABLE(0);

        private final int value;

        DamageAvailability(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    static class MonsterInfo {

        private static final int DAMAGE_THRESHOLD = 100;
        private final int defense;
        private final int penetration;

        public MonsterInfo(int defense, int penetration) {
            this.defense = defense;
            this.penetration = penetration;
        }

        public boolean canReceiveDamage() {
            return (long) defense * (100 - penetration) < (long) DAMAGE_THRESHOLD * 100;
        }
    }
}
