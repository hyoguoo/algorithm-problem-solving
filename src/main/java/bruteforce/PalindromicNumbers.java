/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11068
 * Cheat Level: 0
 * Algorithm: Brute Force / Mathematics
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class PalindromicNumbers {

    private static final char[] DIGITS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/".toCharArray();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            int number = Integer.parseInt(bufferedReader.readLine());

            stringBuilder
                    .append(solution(number) ? 1 : 0)
                    .append(System.lineSeparator());
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static boolean solution(int number) {
        return IntStream.rangeClosed(2, 64)
                .mapToObj(base -> convertToBase(number, base))
                .anyMatch(PalindromicNumbers::isPalindromic);
    }

    private static String convertToBase(int number, int base) {
        StringBuilder result = new StringBuilder();
        while (number > 0) {
            int remainder = number % base;
            result.append(DIGITS[remainder]);
            number /= base;
        }
        return result.reverse().toString();
    }

    private static boolean isPalindromic(String value) {
        return value.contentEquals(new StringBuilder(value).reverse());
    }
}
