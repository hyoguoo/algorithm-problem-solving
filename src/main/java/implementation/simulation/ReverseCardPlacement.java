/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10804
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseCardPlacement {

    private static final int CARD_COUNT = 20;
    private static final int SWAP_COUNT = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Swap[] swaps = new Swap[SWAP_COUNT];
        for (int i = 0; i < SWAP_COUNT; i++) {
            int[] swapInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            swaps[i] = new Swap(swapInfo[0], swapInfo[1]);
        }

        System.out.print(solution(swaps));
    }

    private static String solution(Swap[] swaps) {
        return Arrays.stream(swaps)
                .reduce(new Card(), (card, swap) -> {
                    card.reverse(swap.a, swap.b);
                    return card;
                }, (card1, card2) -> card1)
                .toString();
    }

    static class Card {

        private final int[] cards;

        public Card() {
            this.cards = new int[CARD_COUNT + 1];
            for (int i = 1; i <= CARD_COUNT; i++) {
                cards[i] = i;
            }
        }

        public void reverse(int a, int b) {
            int[] subArray = Arrays.copyOfRange(cards, a, b + 1);

            IntStream.range(0, subArray.length / 2)
                    .forEach(i -> swapElements(subArray, i, subArray.length - 1 - i));

            System.arraycopy(subArray, 0, cards, a, subArray.length);
        }


        private void swapElements(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        @Override
        public String toString() {
            return Arrays.stream(cards)
                    .skip(1)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "));
        }
    }

    static class Swap {

        private final int a;
        private final int b;

        public Swap(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
