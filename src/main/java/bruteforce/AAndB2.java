/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 12919
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AAndB2 {

    static StringBuilder src;
    static String dist;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        dist = bufferedReader.readLine();
        src = new StringBuilder(bufferedReader.readLine());

        solution();
        System.out.println(0);
    }

    private static void solution() {
        if (src.toString().equals(dist)) {
            System.out.println(1);
            System.exit(0);
        }
        else if (src.length() < dist.length()) return;

        if (src.charAt(src.length() - 1) == 'A') {
            src.deleteCharAt(src.length() - 1);
            solution();
            src.append("A");
        }
        if (src.charAt(0) == 'B') {
            src.deleteCharAt(0).reverse();
            solution();
            src.append("B").reverse();
        }
    }
}
