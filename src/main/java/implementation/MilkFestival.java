/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14720
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MilkFestival {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        Milk[] milks = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .mapToObj(Milk::of)
                .toArray(Milk[]::new);

        System.out.print(solution(milks));
    }

    private static long solution(Milk[] milks) {
        MilkTracker milkTracker = new MilkTracker();

        return Arrays.stream(milks)
                .filter(milkTracker::track)
                .count();
    }

    enum Milk {
        STRAWBERRY(0),
        CHOCOLATE(1),
        BANANA(2);

        private final int order;

        Milk(int order) {
            this.order = order;
        }

        public static Milk of(int order) {
            return Arrays.stream(values())
                    .filter(milk -> milk.order == order)
                    .findFirst()
                    .orElseThrow();
        }

        public Milk next() {
            return Arrays.stream(values())
                    .filter(milk -> milk.order == (this.order + 1) % values().length)
                    .findFirst()
                    .orElseThrow();
        }
    }

    static class MilkTracker {

        private Milk expectedMilk = Milk.STRAWBERRY;

        public boolean track(Milk milk) {
            if (milk == expectedMilk) {
                expectedMilk = expectedMilk.next();
                return true;
            }
            return false;
        }
    }
}
