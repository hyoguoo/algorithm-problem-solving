/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1835
 * Cheat Level: 0
 * Algorithm: Deque
 */

package datastructure.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

public class Card {

    public static void main(String[] args) throws IOException {
        System.out.print(
                solution(
                        Integer.parseInt(
                                new BufferedReader(new InputStreamReader(System.in)).readLine()
                        )
                )
        );
    }

    private static String solution(int cardCount) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(cardCount);

        while (deque.size() < cardCount) {
            int cardValue = cardCount - deque.size();
            deque.addFirst(cardValue);
            for (int i = 0; i < cardValue; i++) {
                deque.addFirst(deque.pollLast());
            }
        }

        return deque
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
