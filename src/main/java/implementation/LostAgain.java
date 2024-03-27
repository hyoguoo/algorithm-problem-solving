/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14582
 * Cheat Level: 0
 * Algorithm: Implementation / Prefix Sum
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LostAgain {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers1 = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] numbers2 = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(
                solution(numbers1, numbers2)
                        ? "Yes"
                        : "No"
        );
    }

    private static boolean solution(int[] numbers1, int[] numbers2) {
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < numbers1.length; i++) {
            sum1 += numbers1[i];
            if (sum1 > sum2) {
                return true;
            }
            sum2 += numbers2[i];
        }

        return false;
    }
}
