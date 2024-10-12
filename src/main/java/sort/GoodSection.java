/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1059
 * Cheat Level: 0
 * Algorithm: Sort
 */

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GoodSection {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int target = Integer.parseInt(bufferedReader.readLine());
        System.out.print(solution(numbers, target));
    }

    private static int solution(int[] numbers, int target) {
        Arrays.sort(numbers);
        int count = 0;

        for (int i = 1; i < numbers[0]; i++) {
            for (int j = i + 1; j < numbers[0]; j++) {
                if (i <= target && target <= j) {
                    count++;
                }
            }
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = numbers[i] + 1; j < numbers[i + 1]; j++) {
                for (int k = j + 1; k < numbers[i + 1]; k++) {
                    if (j <= target && target <= k) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
