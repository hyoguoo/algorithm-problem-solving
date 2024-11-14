/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 7795
 * Cheat Level: 0
 * Algorithm: Two Pointer
 */

package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EatOrBeEaten {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();
        while (testCount-- > 0) {
            bufferedReader.readLine();
            int[] numbers1 = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] numbers2 = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            stringBuilder.append(solution(numbers1, numbers2)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static long solution(int[] numbers1, int[] numbers2) {
        Arrays.sort(numbers1);
        Arrays.sort(numbers2);
        int result = 0;
        int numbers2Index = numbers2.length - 1;

        for (int numbers1Index = numbers1.length - 1; numbers1Index >= 0; numbers1Index--) {
            while (numbers1[numbers1Index] <= numbers2[numbers2Index] && numbers2Index > 0) {
                numbers2Index--;
            }
            if (numbers1[numbers1Index] > numbers2[numbers2Index]) {
                result += numbers2Index + 1;
            }
        }

        return result;
    }
}
