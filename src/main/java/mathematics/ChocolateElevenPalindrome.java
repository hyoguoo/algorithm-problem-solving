/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 31460
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChocolateElevenPalindrome {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            int n = Integer.parseInt(bufferedReader.readLine());
            stringBuilder.append(solution(n)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static String solution(int n) {
        if (n == 1) {
            return "0";
        }

        return "1"
                + "2".repeat(Math.max(0, n - 2))
                + "1";
    }
}
