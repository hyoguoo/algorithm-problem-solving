/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2161
 * Cheat Level: 0
 * Algorithm: Implementation / Queue
 */

package datastructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Card1 {

    public static void main(String[] args) throws IOException {
        System.out.println(solution(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine())));
    }

    private static String solution(int n) {
        return getFormattedDiscardedCards(discardCards(n));
    }

    private static List<Integer> discardCards(int n) {
        Deque<Integer> deque = generateDeque(n);

        List<Integer> discardedCards = new ArrayList<>();

        while (!deque.isEmpty()) {
            discardedCards.add(deque.pollFirst());
            if (deque.isEmpty()) break;
            deque.addLast(deque.pollFirst());
        }

        return discardedCards;
    }

    private static Deque<Integer> generateDeque(int n) {
        return IntStream
                .rangeClosed(1, n)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));
    }

    private static String getFormattedDiscardedCards(List<Integer> discardedCards) {
        return discardedCards
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
