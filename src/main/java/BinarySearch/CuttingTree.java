/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2805
 */

package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CuttingTree {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] infos = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long[] trees = Arrays.stream(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long target = infos[1];

        Arrays.sort(trees);
        System.out.println(Collections.max(getLargestTreeHeight(trees, target)));
    }

    private static List<Long> getLargestTreeHeight(long[] trees, long target) {
        List<Long> result = new ArrayList<>();
        long minHeight = 0;
        long maxHeight = trees[trees.length - 1];

        while (minHeight <= maxHeight) {
            long midHeight = (maxHeight + minHeight) / 2;
            long treeLength = getTreeLength(trees, midHeight);
            if (treeLength >= target) {
                result.add(midHeight);
                minHeight = midHeight + 1;
            } else {
                maxHeight = midHeight - 1;
            }
        }

        return result;
    }

    private static long getTreeLength(long[] trees, long midHeight) {
        long sum = 0;
        for (long tree : trees) {
            if (tree > midHeight) sum += tree - midHeight;
        }

        return sum;
    }
}
