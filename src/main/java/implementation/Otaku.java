/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 34921
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Otaku {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Friend friend = new Friend(input[0], input[1]);

        System.out.print(solution(friend));
    }

    private static int solution(Friend friend) {
        int power = Formula.BASE.getValue() +
                Formula.FACTOR.getValue() * (Formula.OFFSET.getValue() - friend.getAge() + friend.getTier());

        return Math.max(Formula.LIMIT.getValue(), power);
    }

    enum Formula {
        BASE(10),
        FACTOR(2),
        OFFSET(25),
        LIMIT(0);

        private final int value;

        Formula(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    static class Friend {

        private final int age;
        private final int tier;

        public Friend(int age, int tier) {
            this.age = age;
            this.tier = tier;
        }

        public int getAge() {
            return age;
        }

        public int getTier() {
            return tier;
        }
    }
}
