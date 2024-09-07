/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10866
 * Cheat Level: 0
 * Algorithm: Deque
 */

package datastructure.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Optional;

public class DequeProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int queryCount = Integer.parseInt(bufferedReader.readLine());
        Query[] queries = new Query[queryCount];

        for (int i = 0; i < queryCount; i++) {
            queries[i] = Query.of(bufferedReader.readLine());
        }

        System.out.print(solution(queries));
    }

    private static String solution(Query[] queries) {
        StringBuilder result = new StringBuilder();
        CommandDeque commandDeque = new CommandDeque();

        Arrays.stream(queries)
                .forEach(
                        query -> commandDeque
                                .executeQuery(query)
                                .ifPresent(e -> result.append(e).append("\n"))
                );

        return result.toString().trim();
    }

    enum Command {
        PUSH_FRONT("push_front"),
        PUSH_BACK("push_back"),
        POP_FRONT("pop_front"),
        POP_BACK("pop_back"),
        SIZE("size"),
        EMPTY("empty"),
        FRONT("front"),
        BACK("back");

        private final String value;

        Command(String value) {
            this.value = value;
        }

        public static Command of(String value) {
            return Arrays.stream(values())
                    .filter(command -> command.value.equals(value))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }

    static class CommandDeque {

        private static final int NO_DATA = -1;
        private static final int EMPTY = 1;
        private static final int NOT_EMPTY = 0;
        private final Deque<Integer> deque;

        public CommandDeque() {
            this.deque = new ArrayDeque<>();
        }

        public Optional<Integer> executeQuery(Query query) {
            switch (query.command) {
                case PUSH_FRONT:
                    pushFront(query.value);
                    return Optional.empty();
                case PUSH_BACK:
                    pushBack(query.value);
                    return Optional.empty();
                case POP_FRONT:
                    return Optional.of(popFront());
                case POP_BACK:
                    return Optional.of(popBack());
                case SIZE:
                    return Optional.of(size());
                case EMPTY:
                    return Optional.of(empty());
                case FRONT:
                    return Optional.of(front());
                case BACK:
                    return Optional.of(back());
                default:
                    throw new IllegalArgumentException();
            }
        }

        private void pushFront(int value) {
            deque.addFirst(value);
        }

        private void pushBack(int value) {
            deque.addLast(value);
        }

        private int popFront() {
            return deque.isEmpty()
                    ? NO_DATA
                    : deque.removeFirst();
        }

        private int popBack() {
            return deque.isEmpty()
                    ? NO_DATA
                    : deque.removeLast();
        }

        private int size() {
            return deque.size();
        }

        private int empty() {
            return deque.isEmpty()
                    ? EMPTY
                    : NOT_EMPTY;
        }

        private int front() {
            return deque.isEmpty()
                    ? NO_DATA
                    : deque.getFirst();
        }

        private int back() {
            return deque.isEmpty()
                    ? NO_DATA
                    : deque.getLast();
        }
    }

    static class Query {

        private final Command command;
        private final Integer value;

        public Query(Command command, Integer value) {
            this.command = command;
            this.value = value;
        }

        public static Query of(String queryString) {
            String[] split = queryString.split(" ");
            Command command = Command.of(split[0]);

            Integer value = split.length > 1
                    ? Integer.parseInt(split[1])
                    : null;

            return new Query(command, value);
        }
    }
}
