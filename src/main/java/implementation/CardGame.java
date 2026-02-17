/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10801
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CardGame {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] aCards = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] bCards = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(aCards, bCards));
    }

    private static Winner solution(int[] aCards, int[] bCards) {
        int aWinCount = 0;
        int bWinCount = 0;

        for (int i = 0; i < 10; i++) {
            if (aCards[i] > bCards[i]) {
                aWinCount++;
            } else if (bCards[i] > aCards[i]) {
                bWinCount++;
            }
        }

        if (aWinCount > bWinCount) {
            return Winner.A;
        } else if (bWinCount > aWinCount) {
            return Winner.B;
        } else {
            return Winner.D;
        }
    }

    private enum Winner {
        A, B, D
    }
}
