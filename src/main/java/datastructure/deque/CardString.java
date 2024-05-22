/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 13417
 * Cheat Level: 0
 * Algorithm: String / Deque
 */

package datastructure.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class CardString {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            bufferedReader.readLine();
            char[] cards = bufferedReader.readLine().replace(" ", "").toCharArray();
            stringBuilder.append(solution(cards)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static String solution(char[] cards) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char card : cards) {
            if (deque.isEmpty()) {
                deque.add(card);
            } else {
                if (deque.getFirst() < card) {
                    deque.addLast(card);
                } else {
                    deque.addFirst(card);
                }
            }
        }

        return concatenateCards(deque);
    }

    private static String concatenateCards(Iterable<Character> deque) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char card : deque) {
            stringBuilder.append(card);
        }

        return stringBuilder.toString();
    }
}
