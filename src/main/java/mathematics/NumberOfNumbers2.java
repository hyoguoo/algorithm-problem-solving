/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 21567
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NumberOfNumbers2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number1 = Integer.parseInt(bufferedReader.readLine());
        int number2 = Integer.parseInt(bufferedReader.readLine());
        int number3 = Integer.parseInt(bufferedReader.readLine());

        System.out.print(solution(number1, number2, number3));
    }

    private static String solution(int number1, int number2, int number3) {
        long product = (long) number1 * number2 * number3;
        int[] digitCount = new int[10];

        while (product > 0) {
            int digit = (int) (product % 10);
            digitCount[digit]++;
            product /= 10;
        }

        return Arrays.stream(digitCount)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
