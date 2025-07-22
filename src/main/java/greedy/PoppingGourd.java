/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 19939
 * Cheat Level: 0
 * Algorithm: Greedy / Mathematics
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PoppingGourd {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int ballCount = info[0];
        int gourdCount = info[1];

        System.out.print(solution(ballCount, gourdCount));
    }

    private static int solution(int ballCount, int gourdCount) {
        int minimumRequiredBalls = gourdCount * (gourdCount + 1) / 2;
        int remainingBalls = ballCount - minimumRequiredBalls;

        if (remainingBalls < 0) {
            return -1;
        }
        return remainingBalls % gourdCount == 0 ? gourdCount - 1 : gourdCount;
    }
}
