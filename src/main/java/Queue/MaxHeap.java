/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11279
 * Cheat Level: 0
 * Algorithm: Heap / Priority Queue
 */

package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeap {

    static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < length; i++) {
            int number = Integer.parseInt(bufferedReader.readLine());
            int result = solution(number);
            if (result >= 0) System.out.println(result);
        }
    }

    private static int solution(int number) {
        if (number == 0) {
            if (priorityQueue.isEmpty()) return 0;
            return priorityQueue.poll();
        } else {
            priorityQueue.add(number);
            return -1;
        }
    }
}
