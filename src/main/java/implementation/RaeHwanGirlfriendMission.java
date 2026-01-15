/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 32529
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class RaeHwanGirlfriendMission {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int targetLoss = info[1];

        int[] dailyLoss = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(dailyLoss, targetLoss));
    }

    private static int solution(int[] dailyLoss, int targetLoss) {
        int totalDays = dailyLoss.length;

        long[] suffixSum = new long[totalDays + 1];

        IntStream.range(0, totalDays)
                .forEach(i -> suffixSum[totalDays - i - 1] =
                        suffixSum[totalDays - i] + dailyLoss[totalDays - i - 1]);

        return IntStream.range(0, totalDays)
                .filter(day -> suffixSum[day] >= targetLoss)
                .reduce((prev, curr) -> curr)
                .stream()
                .map(day -> day + 1)
                .findFirst()
                .orElse(-1);
    }
}
