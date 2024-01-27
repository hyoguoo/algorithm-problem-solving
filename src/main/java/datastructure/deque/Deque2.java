/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 28279
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

public class Deque2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int commandCount = Integer.parseInt(bufferedReader.readLine());

        DequeImpl<Integer> deque = new DequeImpl<>();

        StringBuilder stringBuilder = new StringBuilder();

        while (commandCount-- > 0) {
            String[] command = bufferedReader.readLine().split(" ");
            if (command.length == 1) stringBuilder.append(deque.action(command[0])).append("\n");
            else deque.action(command[0], Integer.parseInt(command[1]));
        }

        System.out.print(stringBuilder);
    }

    static class DequeImpl<T> {

        private final Deque<T> deque = new ArrayDeque<>();

        public String action(String command) {
            switch (Command.of(command)) {
                case POP_FRONT:
                    return deque.isEmpty() ? "-1" : String.valueOf(deque.pollFirst());
                case POP_BACK:
                    return deque.isEmpty() ? "-1" : String.valueOf(deque.pollLast());
                case SIZE:
                    return String.valueOf(deque.size());
                case EMPTY:
                    return deque.isEmpty() ? "1" : "0";
                case FRONT:
                    return deque.isEmpty() ? "-1" : String.valueOf(deque.peekFirst());
                case BACK:
                    return deque.isEmpty() ? "-1" : String.valueOf(deque.peekLast());
                default:
                    throw new IllegalArgumentException();
            }
        }

        public void action(String command, T value) {
            switch (Command.of(command)) {
                case PUSH_FRONT:
                    deque.addFirst(value);
                    break;
                case PUSH_BACK:
                    deque.addLast(value);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }

        enum Command {
            PUSH_FRONT("1"),
            PUSH_BACK("2"),
            POP_FRONT("3"),
            POP_BACK("4"),
            SIZE("5"),
            EMPTY("6"),
            FRONT("7"),
            BACK("8");

            private final String value;

            Command(String value) {
                this.value = value;
            }

            static Command of(String value) {
                return Arrays.stream(values())
                        .filter(command -> command.value.equals(value))
                        .findFirst()
                        .orElseThrow();
            }
        }
    }
}
