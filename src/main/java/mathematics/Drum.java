/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 30890
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Drum {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(info[0], info[1]));
    }

    private static String solution(int leftCount, int rightCount) {
        int lcm = lcm(leftCount, rightCount);

        Hand[] hands = new Hand[lcm + 1];
        int leftPeriod = lcm / leftCount;
        int rightPeriod = lcm / rightCount;

        for (int i = 1; i <= lcm; i++) {
            if (i % leftPeriod == 0 && i % rightPeriod == 0) {
                hands[i] = Hand.BOTH;
            } else if (i % leftPeriod == 0) {
                hands[i] = Hand.LEFT;
            } else if (i % rightPeriod == 0) {
                hands[i] = Hand.RIGHT;
            }
        }

        return handsToString(hands);
    }

    private static String handsToString(Hand[] hands) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i < hands.length; i++) {
            if (hands[i] != null) {
                stringBuilder.append(hands[i].value);
            }

        }

        return stringBuilder.toString();
    }


    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private static int gcd(int a, int b) {
        return b != 0
                ? gcd(b, a % b)
                : a;
    }

    enum Hand {
        LEFT(1),
        RIGHT(2),
        BOTH(3);

        private final int value;

        Hand(int value) {
            this.value = value;
        }
    }
}
