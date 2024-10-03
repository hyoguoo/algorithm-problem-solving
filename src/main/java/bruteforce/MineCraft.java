/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 18111
 * Cheat Level: 0
 * Algorithm: Brute Force / Implementation
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class MineCraft {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sizeN = info[0];
        int sizeM = info[1];
        int blockCount = info[2];

        int[][] mapHeight = new int[sizeN][sizeM];
        for (int i = 0; i < sizeN; i++) {
            mapHeight[i] = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        System.out.print(solution(mapHeight, blockCount));
    }

    private static String solution(int[][] mapHeight, int blockCount) {
        HeightManager heightManager = new HeightManager(mapHeight, blockCount);
        heightManager.execute();
        return heightManager.getResult();
    }

    static class HeightManager {

        private final int initBlock;
        private int[][] mapHeight;
        private int maxHeight;
        private int minHeight;
        private int resultTime = Integer.MAX_VALUE;
        private int resultHeight = Integer.MIN_VALUE;

        public HeightManager(int[][] mapHeight, int initBlock) {
            this.initBlock = initBlock;
            updateMapAndMinMaxHeight(mapHeight);
        }

        private void updateMapAndMinMaxHeight(int[][] original) {
            this.mapHeight = new int[original.length][original[0].length];
            this.minHeight = Integer.MAX_VALUE;
            this.maxHeight = Integer.MIN_VALUE;

            for (int i = 0; i < original.length; i++) {
                for (int j = 0; j < original[i].length; j++) {
                    int height = original[i][j];
                    this.mapHeight[i][j] = height;

                    if (height < this.minHeight) {
                        this.minHeight = height;
                    }
                    if (height > this.maxHeight) {
                        this.maxHeight = height;
                    }
                }
            }
        }

        public void execute() {
            IntStream.range(minHeight, maxHeight + 1)
                    .forEach(this::simulateHeightLevel);
        }

        private void simulateHeightLevel(int targetHeight) {
            BlockTimeResult result = new BlockTimeResult(initBlock);

            for (int i = 0; i < mapHeight.length; i++) {
                for (int j = 0; j < mapHeight[i].length; j++) {
                    int currentHeight = mapHeight[i][j];
                    result.updateTimeAndBlocks(currentHeight - targetHeight);
                }
            }

            if (result.blockCount >= 0) {
                updateResult(result.time, targetHeight);
            }
        }

        private void updateResult(int time, int height) {
            if (time < resultTime) {
                resultTime = time;
                resultHeight = height;
            } else if (time == resultTime) {
                resultHeight = Math.max(resultHeight, height);
            }
        }

        public String getResult() {
            return resultTime + " " + resultHeight;
        }
    }

    static class BlockTimeResult {

        private int time;
        private int blockCount;

        public BlockTimeResult(int blockCount) {
            this.blockCount = blockCount;
            this.time = 0;
        }

        public void updateTimeAndBlocks(int diff) {
            if (diff > 0) {
                blockCount += diff;
                time += diff * 2;
            } else {
                blockCount -= Math.abs(diff);
                time += Math.abs(diff);
            }
        }
    }
}
