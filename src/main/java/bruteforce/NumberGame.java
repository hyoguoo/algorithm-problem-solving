/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2303
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumberGame {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int peopleCount = Integer.parseInt(bufferedReader.readLine());

        Card[] cards = new Card[peopleCount + 1];

        for (int i = 1; i <= peopleCount; i++) {
            int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            cards[i] = new Card(numbers);
        }

        System.out.print(solution(cards));
    }

    private static int solution(Card[] cards) {
        int maxIndex = 0;
        int maxScore = 0;

        for (int i = 1; i < cards.length; i++) {
            int score = cards[i].pick();
            if (maxScore <= score) {
                maxScore = score;
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    static class Card {

        private static final int PICK_COUNT = 3;
        private final int[] numbers;

        public Card(int[] numbers) {
            this.numbers = numbers;
        }

        public int pick() {
            return pickRecursive(0, 0, 0);
        }

        private int pickRecursive(int index, int count, int sum) {
            if (count == PICK_COUNT) {
                return sum % 10;
            }

            int max = 0;

            for (int i = index + 1; i < numbers.length; i++) {
                max = Math.max(max, pickRecursive(i, count + 1, sum + numbers[i]));
            }

            return max;
        }
    }
}
