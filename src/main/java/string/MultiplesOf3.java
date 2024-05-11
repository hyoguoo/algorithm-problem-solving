/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1769
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiplesOf3 {

    public static void main(String[] args) throws IOException {
        System.out.print(
                solution(
                        new BufferedReader(new InputStreamReader(System.in)).readLine()
                )
        );
    }

    private static String solution(String stringValue) {
        int count = 0;

        while (stringValue.length() > 1) {
            int sum = 0;
            for (int i = 0; i < stringValue.length(); i++) {
                sum += stringValue.charAt(i) - '0';
            }
            stringValue = String.valueOf(sum);
            count++;
        }

        return count + "\n" + (Integer.parseInt(stringValue) % 3 == 0 ? "YES" : "NO");
    }
}
