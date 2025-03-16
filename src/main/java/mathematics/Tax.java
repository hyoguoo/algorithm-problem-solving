/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 20492
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tax {

    private static final double FIRST_RATE = 0.78;
    private static final double SECOND_RATE = 0.8;
    private static final double THIRD_RATE = 0.2;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(solution(Integer.parseInt(bufferedReader.readLine())));
    }

    private static String solution(int n) {
        return calculateFirstTax(n) + " " + calculateSecondTax(n);
    }

    private static int calculateFirstTax(int n) {
        return (int) (n * FIRST_RATE);
    }

    private static int calculateSecondTax(int n) {
        return (int) (n * SECOND_RATE + n * THIRD_RATE * FIRST_RATE);
    }
}
