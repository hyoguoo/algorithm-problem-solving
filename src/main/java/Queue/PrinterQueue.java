/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1966
 * Cheat Level: 0
 * Algorithm: Implementation / Queue
 */

package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PrinterQueue {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < length; i++) {
            int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int targetIndex = numbers[1];
            int[] priorityArray = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(solution(getQueue(priorityArray), targetIndex));
        }
    }

    private static int solution(Queue<int[]> queue, int targetIndex) {
        int count = 1;
        while (true) {
            int maxPriority = getMaxPriority(queue);
            int[] poll = queue.poll();
            if (poll[1] == maxPriority) {
                if (poll[0] == targetIndex) return count;
                count++;
            } else {
                queue.add(poll);
            }
        }
    }

    private static Queue<int[]> getQueue(int[] priorityArray) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorityArray.length; i++) {
            queue.add(new int[]{i, priorityArray[i]});
        }
        return queue;
    }

    private static int getMaxPriority(Queue<int[]> queue) {
        int maxPriority = 0;
        for (int[] ints : queue) {
            if (ints[1] > maxPriority) maxPriority = ints[1];
        }
        return maxPriority;
    }
}