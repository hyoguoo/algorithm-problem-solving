/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16112
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Job5th {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int stoneCount = info[1];

        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(numbers, stoneCount));
    }

    private static long solution(int[] numbers, int stoneCount) {
        Arrays.sort(numbers);
        AtomicInteger currentStoneCount = new AtomicInteger(0);

        return Arrays.stream(numbers)
                .mapToLong(number -> {
                    int multiplier = currentStoneCount.getAndIncrement();
                    if (multiplier >= stoneCount) {
                        currentStoneCount.decrementAndGet();
                        multiplier = stoneCount;
                    }
                    return (long) number * multiplier;
                })
                .sum();
    }
}
