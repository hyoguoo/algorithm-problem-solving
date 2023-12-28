/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11652
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package datastructure.mapset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Card {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        Long[] cards = new Long[n];
        for (int i = 0; i < n; i++) cards[i] = Long.parseLong(bufferedReader.readLine());

        System.out.println(solution(cards));
    }

    private static long solution(Long[] cards) {
        Map<Long, Integer> cardCounts = getCardCounts(cards);

        return findMostCommonCard(
                cardCounts,
                getMaxCardCount(cardCounts)
        );
    }

    private static Map<Long, Integer> getCardCounts(Long[] cards) {
        Map<Long, Integer> cardCounts = new HashMap<>();

        for (Long card : cards) cardCounts.put(card, cardCounts.getOrDefault(card, 0) + 1);

        return cardCounts;
    }

    private static int getMaxCardCount(Map<Long, Integer> cardCounts) {
        return cardCounts.values().stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

    private static long findMostCommonCard(Map<Long, Integer> cardCounts, int max) {
        List<Long> maxCards = cardCounts.keySet().stream()
                .filter(card -> cardCounts.get(card) == max)
                .sorted()
                .collect(Collectors.toList());

        return maxCards.get(0);
    }
}
