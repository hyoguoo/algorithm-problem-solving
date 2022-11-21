/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14888
 */

package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class OperatorInterpolation {

    public static int[] NUMBERS;
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();

        NUMBERS = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] operators = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dfs(NUMBERS[0], 1, operators[0], operators[1], operators[2], operators[3]);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void dfs(int number, int index, int plus, int minus, int multiply, int divide) {
        if (index == NUMBERS.length) {
            if (MAX < number) MAX = number;
            if (MIN > number) MIN = number;
            return;
        }

        if (plus > 0) dfs(number + NUMBERS[index], index + 1, plus - 1, minus, multiply, divide);
        if (minus > 0) dfs(number - NUMBERS[index], index + 1, plus, minus - 1, multiply, divide);
        if (multiply > 0) dfs(number * NUMBERS[index], index + 1, plus, minus, multiply - 1, divide);
        if (divide > 0) dfs(number / NUMBERS[index], index + 1, plus, minus, multiply, divide - 1);
    }
}
