/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1546
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Mean {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(numbers));
    }

    public static float solution(int[] numbers) {
        int maximumValue = getMaximumValue(numbers);

        return getMean(numbers) / (float) maximumValue * 100;
    }

    public static float getMean(int[] numbers) {
        return getSum(numbers) / (float) numbers.length;
    }

    public static int getMaximumValue(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[numbers.length - 1];
    }

    private static int getSum(int[] numbers) {
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }
}
