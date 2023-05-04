/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2164
 * Cheat Level: 0
 * Algorithm: Deque
 */

package datastructure.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Card2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        CardDeque cardDeque = new CardDeque(length);

        while (cardDeque.size() > 1) {
            cardDeque.remove();
            cardDeque.moveCard();
        }

        System.out.println(cardDeque.getCard());
    }
}

class CardDeque {
    Queue<Integer> cards;

    public CardDeque(int length) {
        this.cards = new ArrayDeque<>();
        for (int i = 1; i <= length; i++) this.cards.add(i);
    }

    public int size() {
        return this.cards.size();
    }

    public void remove() {
        this.cards.remove();
    }

    public void moveCard() {
        Integer removeCard = this.cards.remove();
        this.cards.add(removeCard);
    }

    public int getCard() {
        return this.cards.element();
    }
}
