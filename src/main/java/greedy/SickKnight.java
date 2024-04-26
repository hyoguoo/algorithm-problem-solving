/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1783
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SickKnight {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(info[0], info[1]));
    }

    private static int solution(int n, int m) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return Math.min(4, (m + 1) / 2);
        } else if (m < 7) {
            return Math.min(4, m);
        }

        return m - 2;
    }
}
