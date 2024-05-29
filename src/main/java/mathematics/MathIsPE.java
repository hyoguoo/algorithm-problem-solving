/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15894
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MathIsPE {

    public static void main(String[] args) throws IOException {
        System.out.print(
                solution(
                        Integer.parseInt(
                                new BufferedReader(new InputStreamReader(System.in)).readLine()
                        )
                )
        );
    }

    private static long solution(int n) {
        return (long) n * 4;
    }
}
