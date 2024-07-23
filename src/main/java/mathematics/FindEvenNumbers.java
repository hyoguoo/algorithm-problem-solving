/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3058
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindEvenNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            stringBuilder.append(solution(numbers)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static String solution(int[] numbers) {
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int number : numbers) {
            if (number % 2 == 0) {
                sum += number;
                min = Math.min(min, number);
            }
        }

        return sum + " " + min;
    }
}
