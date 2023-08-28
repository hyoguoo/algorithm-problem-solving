/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4344
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AboveAverage {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        while (testCount-- > 0) {
            System.out.println(solution(Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()) + "%");
        }
    }

    private static double solution(int[] numbers) {
        numbers = Arrays.copyOfRange(numbers, 1, numbers.length);

        double mean = Arrays.stream(numbers).average().orElseThrow();
        int count = Arrays.stream(numbers).filter(number -> number > mean).toArray().length;

        return (double) count / numbers.length * 100;
    }
}
