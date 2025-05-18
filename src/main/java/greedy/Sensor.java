/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2212
 * Cheat Level: 2
 * Algorithm: Greedy / Sort
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Sensor {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int concentratorCount = Integer.parseInt(bufferedReader.readLine());
        int[] sensorPositions = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(sensorPositions, concentratorCount));
    }

    private static int solution(int[] sensorPositions, int concentratorCount) {
        if (concentratorCount >= sensorPositions.length) {
            return 0;
        }

        int[] sortedSensorPositions = Arrays.stream(sensorPositions)
                .sorted()
                .toArray();
        int[] gaps = IntStream.range(0, sortedSensorPositions.length - 1)
                .map(i -> sortedSensorPositions[i + 1] - sortedSensorPositions[i])
                .toArray();

        int[] reverseSortedGaps = Arrays.stream(gaps)
                .boxed()
                .sorted((a, b) -> Integer.compare(b, a))
                .mapToInt(Integer::intValue)
                .toArray();

        return Arrays.stream(reverseSortedGaps)
                .skip((long) concentratorCount - 1)
                .sum();
    }
}
