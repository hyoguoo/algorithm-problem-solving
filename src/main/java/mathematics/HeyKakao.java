/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 22353
 * Cheat Level: 3
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;

public class HeyKakao {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int minutesPerGame = info[0];
        int winProbability = info[1];
        int increaseRate = info[2];

        System.out.printf("%.7f", solution(minutesPerGame, winProbability, increaseRate));
    }

    private static BigDecimal solution(int minutesPerGame, int winProbability, int increaseRate) {
        MathContext mc = new MathContext(20);
        BigDecimal expectedTime = BigDecimal.ZERO;
        BigDecimal prevLoss = BigDecimal.ONE;
        int turn = 1;
        BigDecimal p = BigDecimal.valueOf(winProbability, 2).round(mc);
        BigDecimal incrementFactor = BigDecimal.valueOf(increaseRate, 2).add(BigDecimal.ONE, mc).round(mc);
        BigDecimal one = BigDecimal.ONE;

        while (true) {
            BigDecimal term = prevLoss
                    .multiply(p, mc)
                    .multiply(BigDecimal.valueOf(turn), mc)
                    .multiply(BigDecimal.valueOf(minutesPerGame), mc);

            expectedTime = expectedTime.add(term, mc);

            if (p.compareTo(one) >= 0) {
                break;
            }

            prevLoss = prevLoss.multiply(one.subtract(p, mc), mc);

            p = p.multiply(incrementFactor, mc).round(mc);
            if (p.compareTo(one) > 0) {
                p = one;
            }

            turn++;
        }

        return expectedTime.round(new MathContext(20));
    }
}
