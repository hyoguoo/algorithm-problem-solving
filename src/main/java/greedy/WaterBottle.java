/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1052
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WaterBottle {

    public static void main(String[] args) throws IOException {
        int[] info = Arrays.stream(
                        new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ")
                )
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(info[0], info[1]));
    }

    private static int solution(int n, int k) {
        int result = 0;

        while (Integer.bitCount(n) > k) {
            n++;
            result++;
        }

        return result;
    }
}
