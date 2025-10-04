/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1668
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class TrophyDisplay {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int trophyCount = Integer.parseInt(bufferedReader.readLine());

        int[] trophyHeights = new int[trophyCount];

        for (int i = 0; i < trophyCount; i++) {
            trophyHeights[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(solution(trophyHeights));
    }

    private static Result solution(int[] trophyHeights) {
        int leftCount = countVisibleTrophies(trophyHeights);
        int[] reversedHeights = IntStream.range(0, trophyHeights.length)
                .map(i -> trophyHeights[trophyHeights.length - 1 - i])
                .toArray();
        int rightCount = countVisibleTrophies(reversedHeights);

        return new Result(leftCount, rightCount);
    }

    private static int countVisibleTrophies(int[] trophyHeights) {
        int count = 0;
        int maxHeight = 0;

        for (int height : trophyHeights) {
            if (height > maxHeight) {
                maxHeight = height;
                count++;
            }
        }

        return count;
    }

    static class Result {

        private final int leftCount;
        private final int rightCount;

        public Result(int leftCount, int rightCount) {
            this.leftCount = leftCount;
            this.rightCount = rightCount;
        }

        @Override
        public String toString() {
            return leftCount + "\n" + rightCount;
        }
    }
}
