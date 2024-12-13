/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9085
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Plus {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0 ) {
            bufferedReader.readLine();
            int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            stringBuilder.append(solution(numbers)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static long solution(int[] numbers) {
        return Arrays.stream(numbers)
                .sum();
    }
}
