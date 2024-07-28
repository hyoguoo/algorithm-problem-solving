/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1977
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PerfectSquare {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(
                solution(
                        Integer.parseInt(bufferedReader.readLine()),
                        Integer.parseInt(bufferedReader.readLine())
                )
        );
    }

    private static String solution(int m, int n) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = m; i <= n; i++) {
            if (isPerfectSquare(i)) {
                sum += i;
                min = Math.min(min, i);
            }
        }

        return sum == 0 ? "-1" : sum + "\n" + min;
    }

    private static boolean isPerfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}
