/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 28136
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RoundTable {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(numbers));
    }

    private static int solution(int[] numbers) {
        int count = 0;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i- 1] >= numbers[i]) {
                count++;
            }
        }
        if (numbers[numbers.length - 1] >= numbers[0]) {
            count++;
        }

        return count;
    }
}
