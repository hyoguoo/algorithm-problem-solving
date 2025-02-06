/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1862
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Meters {

    private static final int BASE = 9;
    private static final int NON_NUNBER = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(solution(Integer.parseInt(bufferedReader.readLine())));
    }

    private static int solution(int n) {
        int result = 0;
        int digit = 0;

        while (n > 0) {
            int remainder = n % 10;
            if (remainder > NON_NUNBER) {
                remainder--;
            }
            result += (int) (Math.pow(BASE, digit) * remainder);
            digit++;
            n /= 10;
        }

        return result;
    }
}
