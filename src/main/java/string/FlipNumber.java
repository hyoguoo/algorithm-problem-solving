/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3062
 * Cheat Level: 0
 * Algorithm: String / Mathematics
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FlipNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        while (testCaseCount-- > 0) {
            int number = Integer.parseInt(bufferedReader.readLine());
            stringBuilder
                    .append(solution(number) ? "YES" : "NO")
                    .append(System.lineSeparator());
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static boolean solution(int number) {
        return isPalindrome(number + reverseNumber(number));
    }

    private static int reverseNumber(int number) {
        return Integer.parseInt(new StringBuilder(String.valueOf(number)).reverse().toString());
    }

    private static boolean isPalindrome(int number) {
        String numberString = String.valueOf(number);
        return numberString.contentEquals(new StringBuilder(numberString).reverse());
    }
}
