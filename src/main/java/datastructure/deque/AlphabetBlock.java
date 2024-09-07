/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 27497
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
import java.util.stream.Collectors;

public class AlphabetBlock {

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
        AlphabetBlockDeque alphabetBlockDeque = new AlphabetBlockDeque();

        Arrays.stream(queries)
                .forEach(alphabetBlockDeque::executeQuery);

        return alphabetBlockDeque.toString();
    }

    enum Command {
        ADD_TO_END("1"),
        ADD_TO_FRONT("2"),
        REMOVE_LAST("3");

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

    static class HistoryStack {

        private final Deque<Command> commands;

        public HistoryStack() {
            this.commands = new ArrayDeque<>();
        }

        public void add(Command command) {
            if (command == Command.REMOVE_LAST) {
                return;
            }
            commands.addLast(command);
        }

        public Command pop() {
            return commands.pollLast();
        }
    }

    static class AlphabetBlockDeque {

        private final Deque<Character> deque;
        private final HistoryStack historyStack;

        public AlphabetBlockDeque() {
            this.deque = new ArrayDeque<>();
            this.historyStack = new HistoryStack();
        }

        public void executeQuery(Query query) {
            switch (query.command) {
                case ADD_TO_END:
                    addToEnd(query.alphabet);
                    break;
                case ADD_TO_FRONT:
                    addToFront(query.alphabet);
                    break;
                case REMOVE_LAST:
                    removeLast();
                    break;
            }
        }

        private void addToEnd(Character alphabet) {
            deque.addLast(alphabet);
            historyStack.add(Command.ADD_TO_END);
        }

        private void addToFront(Character alphabet) {
            deque.addFirst(alphabet);
            historyStack.add(Command.ADD_TO_FRONT);
        }

        private void removeLast() {
            if (deque.isEmpty()) {
                return;
            }

            switch (historyStack.pop()) {
                case ADD_TO_END:
                    deque.pollLast();
                    break;
                case ADD_TO_FRONT:
                    deque.pollFirst();
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override
        public String toString() {
            if (deque.isEmpty()) {
                return "0";
            }

            return deque.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
        }
    }

    static class Query {

        private final Command command;
        private final Character alphabet;

        public Query(Command command, Character alphabet) {
            this.command = command;
            this.alphabet = alphabet;
        }

        public static Query of(String queryString) {
            String[] split = queryString.split(" ");
            Command command = Command.of(split[0]);

            Character alphabet = split.length > 1 ? split[1].charAt(0) : null;

            return new Query(command, alphabet);
        }
    }
}
