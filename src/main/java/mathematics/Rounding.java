/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2033
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rounding {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(solution(Integer.parseInt(bufferedReader.readLine())));
    }

    private static int solution(int n) {
        int length = String.valueOf(n).length();

        for (int digit = 1; digit < length; digit++) {
            int remainder = n % (int) Math.pow(10, digit);

            if (remainder >= Math.pow(10, digit) / 2) {
                n += (int) Math.pow(10, digit);
            }

            n -= remainder;
        }

        return n;
    }
}
