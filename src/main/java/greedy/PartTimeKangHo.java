/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1758
 * Cheat Level: 0
 * Algorithm: Greedy / Sort
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PartTimeKangHo {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] tips = new int[n];

        for (int i = 0; i < n; i++) {
            tips[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(solution(tips));
    }

    private static long solution(int[] tips) {
        Arrays.sort(tips);

        long result = 0;

        for (int i = tips.length - 1; i >= 0; i--) {
            int tip = tips[i] - (tips.length - i - 1);
            result += Math.max(tip, 0);
        }

        return result;
    }
}
