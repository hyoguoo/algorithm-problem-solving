/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10828
 * Cheat Level: 0
 * Algorithm: Stack
 */

package datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Optional;

public class StackProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int queryCount = Integer.parseInt(bufferedReader.readLine());
        List<Query> queryList = new ArrayList<>();

        for (int i = 0; i < queryCount; i++) {
            String[] query = bufferedReader.readLine().split(" ");
            if (query.length == 1) {
                queryList.add(new Query(Command.of(query[0])));
            } else {
                queryList.add(new Query(Command.of(query[0]), Integer.parseInt(query[1])));
            }
        }

        System.out.print(solution(queryList));
    }

    private static String solution(List<Query> queryList) {
        StackImpl stack = new StackImpl();

        queryList.forEach(stack::executeQuery);

        return stack.printQueryResult();
    }

    enum Command {
        PUSH("push"),
        POP("pop"),
        SIZE("size"),
        EMPTY("empty"),
        TOP("top");

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

    static class StackImpl {

        private final Deque<Integer> deque;
        private final List<Integer> queryResultList;

        public StackImpl() {
            this.deque = new ArrayDeque<>();
            this.queryResultList = new ArrayList<>();
        }

        public void push(Integer value) {
            deque.push(value);
        }

        public int pop() {
            return deque.isEmpty()
                    ? -1
                    : deque.pop();
        }

        public int size() {
            return deque.size();
        }

        public int empty() {
            return deque.isEmpty()
                    ? 1
                    : 0;
        }

        public int top() {
            return deque.isEmpty()
                    ? -1
                    : deque.peek();
        }

        public void executeQuery(Query query) {
            switch (query.getCommand()) {
                case PUSH:
                    push(query.getValue());
                    break;
                case POP:
                    queryResultList.add(pop());
                    break;
                case SIZE:
                    queryResultList.add(size());
                    break;
                case EMPTY:
                    queryResultList.add(empty());
                    break;
                case TOP:
                    queryResultList.add(top());
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public String printQueryResult() {
            StringBuilder result = new StringBuilder();
            queryResultList.forEach(value -> result.append(value).append("\n"));
            return result.toString().trim();
        }
    }

    static class Query {

        private final Command command;
        private final Integer value;

        public Query(Command command) {
            this.command = command;
            this.value = null;
        }

        public Query(Command command, Integer value) {
            this.command = command;
            this.value = value;
        }

        public Command getCommand() {
            return command;
        }

        public Integer getValue() {
            return Optional.ofNullable(value)
                    .orElseThrow(IllegalArgumentException::new);
        }
    }
}
