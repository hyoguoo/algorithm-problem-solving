/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16471
 * Cheat Level: 0
 * Algorithm: Greedy / Sort
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.IntUnaryOperator;

public class SmallBet {

    private static final IntUnaryOperator WINNING_SCORE = n -> (n + 1) / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] myCards = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] opponentCards = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(myCards, opponentCards) ? "YES" : "NO");
    }

    private static boolean solution(int[] myCards, int[] opponentCards) {
        int winningScore = WINNING_SCORE.applyAsInt(myCards.length);
        int[] sortedMyCards = getSortedCards(myCards);
        int[] sortedOpponentCards = getSortedCards(opponentCards);

        return canWin(sortedMyCards, sortedOpponentCards, winningScore);
    }

    private static boolean canWin(int[] sortedMyCards, int[] sortedOpponentCards, int winningScore) {
        int winCount = 0;
        int myIndex = 0;
        int opponentIndex = 0;

        while (myIndex < sortedMyCards.length) {
            int myCard = sortedMyCards[myIndex];
            int opponentCard = sortedOpponentCards[opponentIndex];
            if (myCard < opponentCard) {
                winCount++;
                opponentIndex++;
            }
            if (winCount >= winningScore) {
                return true;
            }
            myIndex++;
        }

        return false;
    }

    private static int[] getSortedCards(int[] cards) {
        return Arrays.stream(cards)
                .boxed()
                .sorted((a, b) -> b - a)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
