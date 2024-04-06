/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1448
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CreateTriangle {

    public static void main(String[] args) throws IOException {
        System.out.print(solution(parseNumbers()));
    }

    private static int solution(int[] numbers) {
        Arrays.sort(numbers);

        for (int i = numbers.length - 3; i >= 0; i--) {
            if (numbers[i] + numbers[i + 1] > numbers[i + 2]) {
                return numbers[i] + numbers[i + 1] + numbers[i + 2];
            }
        }

        return -1;
    }

    private static int[] parseNumbers() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(bufferedReader.readLine());
        }

        return numbers;
    }
}
