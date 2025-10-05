/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4504
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindMultiples {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            int m = Integer.parseInt(bufferedReader.readLine());
            if (m == 0) {
                break;
            }
            stringBuilder.append(String.format("%d is %sa multiple of %d.%n", m, solution(m, n) ? "" : "NOT ", n));
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static boolean solution(int m, int n) {
        return m % n == 0;
    }
}
