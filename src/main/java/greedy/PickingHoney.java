/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 21758
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PickingHoney {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        System.out.print(
                solution(
                        Arrays.stream(bufferedReader.readLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray()
                )
        );
    }

    private static int solution(int[] honey) {
        int length = honey.length;
        int[] sum = getPrefixSum(honey, length);

        int result = 0;

        for (int i = 1; i < length - 1; i++) {
            int case1 = sum[length - 1] - honey[0] - honey[i] + sum[length - 1] - sum[i];
            int case2 = sum[length - 2] - sum[i - 1] + sum[i] - sum[0];
            int case3 = sum[length - 2] - honey[i] + sum[i - 1];
            result = Math.max(result, Math.max(case1, Math.max(case2, case3)));
        }

        return result;
    }

    private static int[] getPrefixSum(int[] honey, int length) {
        int[] sum = new int[length];

        for (int i = 0; i < length; i++) {
            sum[i] = honey[i];
            if (i > 0) {
                sum[i] += sum[i - 1];
            }
        }
        return sum;
    }
}
