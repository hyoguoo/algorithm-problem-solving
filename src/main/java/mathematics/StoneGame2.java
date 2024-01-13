/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9656
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StoneGame2 {

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        System.out.print(
                n % 4 == 1 || n % 4 == 3
                        ? "CY"
                        : "SK"
        );
    }
}
