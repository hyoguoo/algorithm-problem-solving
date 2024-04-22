/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2417
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SquareInteger {

    public static void main(String[] args) throws IOException {
        System.out.print(
                solution(
                        Long.parseLong(
                                new BufferedReader(new InputStreamReader(System.in)).readLine()
                        )
                )
        );
    }

    public static long solution(long n) {
        long sqrt = (long) Math.sqrt(n);

        if ((sqrt * sqrt) < n) {
            sqrt++;
        }

        return sqrt;
    }
}
