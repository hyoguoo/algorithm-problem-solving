/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1927
 * Cheat Level: 0
 * Algorithm: Heap / Priority Queue
 */

package datastructure.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinHeap {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        int[] queries = new int[n];

        for (int i = 0; i < n; i++) {
            queries[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(solution(queries));
    }

    private static String solution(int[] queries) {
        PriorityQueueImpl priorityQueue = new PriorityQueueImpl();
        Arrays.stream(queries)
                .forEach(priorityQueue::executeQuery);
        return priorityQueue.formatPolledList();
    }

    static class PriorityQueueImpl {

        private static final int POLL_SIGNAL = 0;
        private static final int EMPTY_VALUE = 0;
        private final PriorityQueue<Integer> queue;
        private final List<Integer> polledList;

        public PriorityQueueImpl() {
            this.queue = new PriorityQueue<>();
            this.polledList = new ArrayList<>();
        }

        public void executeQuery(int query) {
            if (query == POLL_SIGNAL) {
                poll();
            } else {
                add(query);
            }
        }

        private void poll() {
            if (queue.isEmpty()) {
                polledList.add(EMPTY_VALUE);
            } else {
                polledList.add(queue.poll());
            }
        }

        private void add(int query) {
            queue.add(query);
        }

        public String formatPolledList() {
            StringBuilder stringBuilder = new StringBuilder();
            Arrays.stream(polledList.toArray())
                    .forEach(e -> stringBuilder.append(e).append("\n"));
            return stringBuilder.toString().trim();
        }
    }
}
