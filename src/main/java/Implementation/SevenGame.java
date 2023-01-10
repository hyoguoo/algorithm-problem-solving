/*
 * goormlevel
 * https://level.goorm.io
 * Monday Challenge: 6주차 문제 1
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SevenGame {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            int[] numbers = Arrays.stream(bufferedReader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            int[] result = solution(numbers);
            System.out.println(result[0] * result[1] % 10);
        }
    }

    public static int[] solution(int[] numbers) {
        int sum = 0;
        int multiply = 1;

        for (int i = 1; i <= numbers.length; i++) {
            if (i % 2 != 0) sum += numbers[i - 1];
            if (i % 2 == 0 && numbers[i - 1] != 0) multiply *= numbers[i - 1];
        }

        return new int[]{sum, multiply};
    }
}
