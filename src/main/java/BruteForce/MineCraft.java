/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 18111
 */

package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MineCraft {

    static int currentBlocks;
    static int minTime = Integer.MAX_VALUE;
    static int minTimeHeight = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] infos = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        currentBlocks = infos[2];
        List<Integer> heightList = new ArrayList<>();
        for (int i = 0; i < infos[0]; i++) {
            int[] heights = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int height : heights) {
                heightList.add(height);
            }
        }

        getMinTime(heightList, Collections.min(heightList), Collections.max(heightList));
        System.out.println(minTime + " " + minTimeHeight);
    }

    private static void getMinTime(List<Integer> heightList, int min, int max) {
        int originalBlocks = currentBlocks;

        for (int i = min; i <= max; i++) {
            currentBlocks = originalBlocks;
            int time = getTime(heightList, i);
            if (minTime >= time && currentBlocks >= 0) {
                minTime = time;
                if (minTimeHeight < i) minTimeHeight = i;
            }
        }
    }

    private static int getTime(List<Integer> heightList, int target) {
        int time = 0;

        for (Integer height : heightList) {
            if (height < target) time += stackUpBlocks(target - height);
            else if (height > target) time += clearBlocks(height - target);
        }

        return time;
    }

    private static int clearBlocks(int blockCount) {
        currentBlocks += blockCount;
        return blockCount * 2;
    }

    private static int stackUpBlocks(int blockCount) {
        currentBlocks -= blockCount;
        return blockCount;
    }
}
