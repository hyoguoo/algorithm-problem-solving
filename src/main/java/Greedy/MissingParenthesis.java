/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1541
 * Cheat Level: 0
 * Algorithm: Greedy / Mathematics
 */

package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MissingParenthesis {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        String[] splitByMinus = input.split("-");

        System.out.println((getMinNumber(splitByMinus)));
    }

    private static int getMinNumber(String[] splitByMinus) {
        int result = 0;

        for (int i = 0; i < splitByMinus.length; i++) {
            int[] numbers = Arrays.stream(splitByMinus[i].split("\\+")).mapToInt(Integer::parseInt).toArray();
            int sum = getSum(numbers);
            if (i == 0) result += sum;
            else result -= sum;
        }

        return result;
    }

    private static int getSum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) sum += number;
        return sum;
    }
}