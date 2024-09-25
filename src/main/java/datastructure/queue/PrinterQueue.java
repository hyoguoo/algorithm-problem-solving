/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1966
 * Cheat Level: 0
 * Algorithm: Implementation / Queue
 */

package datastructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrinterQueue {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int targetIndex = info[1];

            int[] documents = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            stringBuilder.append(solution(documents, targetIndex)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int[] documents, int targetIndex) {
        QueueImpl queue = new QueueImpl(documents);
        int count = 0;

        while (true) {
            Document document = queue.poll();
            count++;

            if (document.isEqualsIndex(targetIndex)) {
                return count;
            }
        }
    }

    static class QueueImpl {

        private final Queue<Document> queue;
        private final PriorityQueue<Integer> priorityQueue;

        public QueueImpl(int[] documents) {
            this.queue = new LinkedList<>();
            priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for (int i = 0; i < documents.length; i++) {
                queue.offer(new Document(i, documents[i]));
                priorityQueue.offer(documents[i]);
            }
        }

        public Document poll() {
            moveToHighestPriority();

            return queue.poll();
        }

        private void moveToHighestPriority() {
            while (!queue.isEmpty() && !priorityQueue.isEmpty() &&
                    !queue.peek().isEqualsPriority(priorityQueue.peek())) {
                queue.offer(queue.poll());
            }

            priorityQueue.poll();
        }
    }

    static class Document {

        private final int index;
        private final int priority;

        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }

        public boolean isEqualsPriority(int priority) {
            return this.priority == priority;
        }

        public boolean isEqualsIndex(int index) {
            return this.index == index;
        }
    }
}
