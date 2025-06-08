/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 20915
 * Cheat Level: 2
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

public class NumberCardGame {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            int[] cards = Arrays.stream(bufferedReader.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            stringBuilder.append(solution(cards)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static BigInteger solution(int[] cards) {
        int[] convertedSortedCards = getConvertedSortedCards(cards);
        int zeroCount = countZeroNumber(cards);
        if (convertedSortedCards.length < 2) {
            return BigInteger.ZERO;
        }

        long leftValue = convertedSortedCards[0];
        long rightValue = convertedSortedCards[1];
        long maxValue = leftValue * rightValue;

        for (int newCardIndex = 2; newCardIndex < convertedSortedCards.length; newCardIndex++) {
            if (leftValue < rightValue) {
                leftValue = leftValue * 10 + convertedSortedCards[newCardIndex];
            } else {
                rightValue = rightValue * 10 + convertedSortedCards[newCardIndex];
            }

            maxValue = Math.max(maxValue, leftValue * rightValue);
        }

        return BigInteger.valueOf(maxValue)
                .multiply(BigInteger.TEN.pow(zeroCount));
    }

    private static int[] getConvertedSortedCards(int[] cards) {
        return Arrays.stream(cards)
                .map(card -> card == 6 ? 9 : card)
                .filter(card -> card != 0)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static int countZeroNumber(int[] cards) {
        return (int) Arrays.stream(cards)
                .filter(card -> card == 0)
                .count();
    }
}
