/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1312
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Decimal {

    public static void main(String[] args) throws IOException {
        int[] info = Arrays.stream(
                        new BufferedReader(new InputStreamReader(System.in))
                                .readLine()
                                .split(" ")
                )
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(info[0], info[1], info[2]));
    }

    private static int solution(int a, int b, int n) {
        a %= b;
        for (int i = 0; i < n - 1; i++) {
            a = (a * 10) % b;
        }
        return (a * 10) / b;
    }
}
