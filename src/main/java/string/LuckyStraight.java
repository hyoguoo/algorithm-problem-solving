/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 18406
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LuckyStraight {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(solution(bufferedReader.readLine()) ? "LUCKY" : "READY");
    }

    private static boolean solution(String s) {
        int half = s.length() / 2;
        String left = s.substring(0, half);
        String right = s.substring(half);

        return sumOfDigits(left) == sumOfDigits(right);
    }

    private static int sumOfDigits(String s) {
        return s.chars()
                .map(c -> c - '0')
                .sum();
    }
}
