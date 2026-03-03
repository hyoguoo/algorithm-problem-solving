/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 21965
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ToweringAboveLoftyNamsanMountain {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] heights = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(heights) ? "YES" : "NO");
    }

    private static boolean solution(int[] heights) {
        HeightStatus heightStatus = new HeightStatus();

        return IntStream.range(1, heights.length)
                .allMatch(i -> heightStatus.update(heights[i], heights[i - 1]));
    }

    static class HeightStatus {

        private boolean isDecreasing = false;

        public boolean update(int currentHeight, int previousHeight) {
            if (currentHeight > previousHeight) {
                return !isDecreasing;
            }
            if (currentHeight < previousHeight) {
                isDecreasing = true;
                return true;
            }
            return false;
        }
    }
}
