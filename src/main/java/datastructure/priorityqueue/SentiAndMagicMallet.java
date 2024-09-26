/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 19638
 * Cheat Level: 0
 * Algorithm: Priority Queue
 */

package datastructure.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SentiAndMagicMallet {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int peopleCount = info[0];
        int targetHeight = info[1];
        int limit = info[2];
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < peopleCount; i++) {
            queue.add(Integer.valueOf(bufferedReader.readLine()));
        }

        System.out.print(solution(queue, targetHeight, limit));
    }

    private static String solution(PriorityQueue<Integer> queue, int targetHeight, int limit) {
        int count = adjustHeights(queue, targetHeight, limit);
        return getResult(queue, targetHeight, count);
    }

    private static int adjustHeights(PriorityQueue<Integer> queue, int targetHeight, int limit) {
        int count = 0;

        for (int i = 0; i < limit; i++) {
            if (shouldStopAdjustment(queue, targetHeight)) {
                break;
            }
            adjustSingleHeight(queue);
            count++;
        }
        return count;
    }

    private static boolean shouldStopAdjustment(PriorityQueue<Integer> queue, int targetHeight) {
        return queue.element() < targetHeight || queue.element() == 1;
    }

    private static void adjustSingleHeight(PriorityQueue<Integer> queue) {
        queue.add(queue.poll() / 2);
    }

    private static String getResult(PriorityQueue<Integer> queue, int targetHeight, int count) {
        return queue.element() < targetHeight
                ? "YES\n" + count
                : "NO\n" + queue.element();
    }
}
