/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 33257
 * Cheat Level: 0
 * Algorithm: Greedy / Sort
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PhysicsExperimentsBySanghyunLee1ExperimentalOperation {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int diffLimit = info[1];
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(numbers, diffLimit));
    }

    private static int solution(int[] numbers, int diffLimit) {
        int[] sortedNumbers = Arrays.stream(numbers)
                .sorted()
                .toArray();

        int result = 1;
        int currentNumber = numbers[0];

        for (int number : sortedNumbers) {
            int diff = number - currentNumber;
            currentNumber = number;
            if (diff < diffLimit) {
                continue;
            }
            result++;
        }

        return result;
    }
}
