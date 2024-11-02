/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5565
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Receipts {

    private static final int BOOK_COUNT = 9;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int totalPrice = Integer.parseInt(bufferedReader.readLine());
        int[] bookPrices = new int[BOOK_COUNT];

        for (int i = 0; i < BOOK_COUNT; i++) {
            bookPrices[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(solution(totalPrice, bookPrices));
    }

    private static int solution(int totalPrice, int[] bookPrices) {
        return totalPrice - Arrays.stream(bookPrices).sum();
    }
}
