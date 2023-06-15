/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15810
 * Cheat Level: 0
 * Algorithm: Binary Search
 */

package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BalloonFactory {

    final static List<Long> CAPACITY_LIST = new ArrayList<>();
    final static long MAX = 1_000_000_000_000L;
    static int N, TARGET;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solution());
    }

    private static long solution() {
        long left = 0;
        long right = MAX;

        while (left <= right) {
            long mid = (left + right) / 2;
            long balloonCount = getBalloonCount(mid);
            if (balloonCount < TARGET) left = mid + 1;
            else right = mid - 1;
        }

        return left;
    }

    private static long getBalloonCount(long time) {
        return CAPACITY_LIST.stream().mapToLong(capacity -> time / capacity).sum();
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        TARGET = info[1];
        long[] capacities = Arrays.stream(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        for (long capacity : capacities) CAPACITY_LIST.add(capacity);
    }
}
