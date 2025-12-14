/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 29752
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestStreak {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] solvedCounts = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(solvedCounts));
    }

    private static int solution(int[] solvedCounts) {
        StreakTracker tracker = new StreakTracker();

        Arrays.stream(solvedCounts)
                .forEach(tracker::accumulate);

        return tracker.result();
    }

    static class StreakTracker {

        private int current;
        private int max;

        public void accumulate(int solved) {
            if (solved > 0) {
                current++;
                max = Math.max(max, current);
            } else {
                current = 0;
            }
        }

        public int result() {
            return max;
        }
    }
}
