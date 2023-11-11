/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1655
 * Cheat Level: 2
 * Algorithm: Priority Queue
 */

package datastructure.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SayCenter {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(bufferedReader.readLine());

            if (minHeap.size() == maxHeap.size()) maxHeap.add(number);
            else minHeap.add(number);

            if (!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
                int temp = minHeap.poll();
                minHeap.add(maxHeap.poll());
                maxHeap.add(temp);
            }

            stringBuilder.append(maxHeap.peek()).append("\n");
        }

        System.out.println(stringBuilder);
    }
}
