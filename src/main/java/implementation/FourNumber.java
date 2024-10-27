/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10824
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FourNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] stringNumbers = bufferedReader.readLine().split(" ");

        System.out.print(solution(stringNumbers[0], stringNumbers[1], stringNumbers[2], stringNumbers[3]));
    }

    private static String solution(String stringNumber1,
            String stringNumber2,
            String stringNumber3,
            String stringNumber4) {
        long number1 = Long.parseLong(stringNumber1 + stringNumber2);
        long number2 = Long.parseLong(stringNumber3 + stringNumber4);

        return String.valueOf(number1 + number2);
    }
}
