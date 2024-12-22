/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 22951
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SongeCardGame {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int peopleCount = info[0];

        List<Card> cardList = new ArrayList<>();

        for (int i = 1; i <= peopleCount; i++) {
            int personNumber = i;
            Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .forEach(cardNumber -> cardList.add(new Card(personNumber, cardNumber)));
        }

        System.out.print(solution(cardList));
    }

    private static String solution(List<Card> cardList) {
        int pickOrder = 0;

        while (cardList.size() > 1) {
            Card card = cardList.get(pickOrder);
            cardList.remove(pickOrder);
            pickOrder = (pickOrder + card.cardNumber - 1) % cardList.size();
        }

        return cardList.get(0).toString();
    }

    static class Card {

        private final int personNumber;
        private final int cardNumber;

        public Card(int personNumber, int cardNumber) {
            this.personNumber = personNumber;
            this.cardNumber = cardNumber;
        }

        @Override
        public String toString() {
            return personNumber + " " + cardNumber;
        }
    }
}
