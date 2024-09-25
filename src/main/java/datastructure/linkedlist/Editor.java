/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1406
 * Cheat Level: 0
 * Algorithm:
 */

package datastructure.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Optional;

public class Editor {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String text = bufferedReader.readLine();

        int queryCount = Integer.parseInt(bufferedReader.readLine());
        List<Query> queryList = new ArrayList<>();

        for (int i = 0; i < queryCount; i++) {
            String[] query = bufferedReader.readLine().split(" ");
            if (query.length == 1) {
                queryList.add(new Query(Command.of(query[0])));
            } else {
                queryList.add(new Query(Command.of(query[0]), query[1].charAt(0)));
            }
        }

        System.out.print(solution(text, queryList));
    }

    private static String solution(String text, List<Query> queryList) {
        Text textEditor = new Text(text);

        queryList.forEach(textEditor::executeQuery);

        return textEditor.toString();
    }

    enum Command {
        LEFT("L"),
        RIGHT("D"),
        DELETE("B"),
        INSERT("P");

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

    static class Text {

        private final Deque<Character> leftStack;
        private final Deque<Character> rightStack;

        public Text(String text) {
            this.leftStack = new ArrayDeque<>();
            this.rightStack = new ArrayDeque<>();

            for (char c : text.toCharArray()) {
                leftStack.push(c);
            }
        }

        public void executeQuery(Query query) {
            switch (query.getCommand()) {
                case LEFT:
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case RIGHT:
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                    break;
                case DELETE:
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    break;
                case INSERT:
                    leftStack.push(query.getValue());
                    break;
            }
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();

            leftStack.descendingIterator()
                    .forEachRemaining(stringBuilder::append);

            rightStack.iterator()
                    .forEachRemaining(stringBuilder::append);

            return stringBuilder.toString().trim();
        }
    }

    static class Query {

        private final Command command;
        private final Character value;

        public Query(Command command) {
            this.command = command;
            this.value = null;
        }

        public Query(Command command, Character value) {
            this.command = command;
            this.value = value;
        }

        public Command getCommand() {
            return command;
        }

        public Character getValue() {
            return Optional.ofNullable(value)
                    .orElseThrow(IllegalArgumentException::new);
        }
    }
}
