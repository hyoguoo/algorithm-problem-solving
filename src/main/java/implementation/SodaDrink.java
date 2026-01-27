/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5032
 * Cheat Level: 0
 * Algorithm: Mathematics / Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SodaDrink {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int initialEmptyBottles = info[0];
        int foundEmptyBottles = info[1];
        int bottlesNeededForExchange = info[2];

        System.out.println(solution(initialEmptyBottles, foundEmptyBottles, bottlesNeededForExchange));
    }

    private static int solution(int initialEmptyBottles,
            int foundEmptyBottles,
            int bottlesNeededForExchange) {
        int currentEmptyBottles = initialEmptyBottles + foundEmptyBottles;
        int totalDrinksConsumed = 0;

        while (currentEmptyBottles >= bottlesNeededForExchange) {
            int newDrinks = currentEmptyBottles / bottlesNeededForExchange;
            totalDrinksConsumed += newDrinks;

            currentEmptyBottles = (currentEmptyBottles % bottlesNeededForExchange) + newDrinks;
        }

        return totalDrinksConsumed;
    }
}
