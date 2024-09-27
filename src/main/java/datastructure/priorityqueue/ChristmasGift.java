/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14235
 * Cheat Level: 0
 * Algorithm: Priority Queue
 */

package datastructure.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class ChristmasGift {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        Query[] queries = new Query[n];

        for (int i = 0; i < n; i++) {
            String[] query = bufferedReader.readLine().split(" ");
            if (query.length == 1) {
                queries[i] = new Query(Command.of(query[0]));
            } else {
                int[] values = new int[query.length - 1];
                Arrays.setAll(values, j -> Integer.parseInt(query[j + 1]));
                queries[i] = new Query(Command.of(query[0]), values);
            }
        }

        System.out.print(solution(queries));
    }

    private static String solution(Query[] queries) {
        PriorityQueueImpl priorityQueue = new PriorityQueueImpl();
        Arrays.stream(queries)
                .forEach(priorityQueue::executeQuery);
        return priorityQueue.formatPolledList();
    }

    static class PriorityQueueImpl {

        private static final int EMPTY_VALUE = -1;
        private final PriorityQueue<Integer> queue;
        private final List<Integer> polledList;

        public PriorityQueueImpl() {
            this.queue = new PriorityQueue<>(Comparator.reverseOrder());
            this.polledList = new ArrayList<>();
        }

        public void executeQuery(Query query) {
            if (query.command == Command.POLL) {
                poll();
            } else {
                add(query.values);
            }
        }

        private void poll() {
            if (queue.isEmpty()) {
                polledList.add(EMPTY_VALUE);
            } else {
                polledList.add(queue.poll());
            }
        }

        private void add(int[] values) {
            Arrays.stream(values)
                    .forEach(queue::add);
        }

        public String formatPolledList() {
            return polledList.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining("\n"));
        }
    }

    enum Command {
        ADD,
        POLL;

        public static Command of(String command) {
            if (command.equals("0")) {
                return POLL;
            }
            return ADD;
        }
    }

    static class Query {

        private final Command command;
        private final int[] values;

        public Query(Command command) {
            this.command = command;
            this.values = null;
        }

        public Query(Command command, int[] values) {
            this.command = command;
            this.values = values;
        }
    }
}
