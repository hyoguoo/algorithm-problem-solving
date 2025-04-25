/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3231
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class PlayingCard {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int cardCount = Integer.parseInt(bufferedReader.readLine());
        int[] cards = new int[cardCount];
        for (int i = 0; i < cardCount; i++) {
            cards[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(solution(cards));
    }

    private static long solution(int[] cards) {
        int[] orders = new int[cards.length];
        for (int i = 0; i < cards.length; i++) {
            orders[cards[i] - 1] = i;
        }
        return IntStream.range(0, orders.length - 1)
                .filter(i -> orders[i] > orders[i + 1])
                .count();
    }
}
