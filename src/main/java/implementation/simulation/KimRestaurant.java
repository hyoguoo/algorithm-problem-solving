/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14612
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class KimRestaurant {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = bufferedReader.readLine().split(" ");
        int queryCount = Integer.parseInt(info[0]);

        List<Command> commands = new ArrayList<>();
        for (int i = 0; i < queryCount; i++) {
            commands.add(Command.from(bufferedReader.readLine()));
        }

        System.out.print(solution(commands));
    }

    private static Result solution(List<Command> commands) {
        Kitchen kitchen = new Kitchen();
        List<List<Integer>> history = new ArrayList<>();

        for (Command command : commands) {
            kitchen.execute(command);
            history.add(kitchen.getCurrentTableNumbers());
        }

        return new Result(history);
    }

    enum CommandType {
        ORDER, SORT, COMPLETE;

        public static CommandType of(String type) {
            return valueOf(type.toUpperCase());
        }
    }

    static class Kitchen {

        private final List<PostIt> postIts = new ArrayList<>();

        public void execute(Command command) {
            switch (command.type) {
                case ORDER:
                    postIts.add(new PostIt(command.tableNumber, command.time));
                    break;
                case SORT:
                    postIts.sort(Comparator.comparingInt(PostIt::getTime)
                            .thenComparingInt(PostIt::getTableNumber));
                    break;
                case COMPLETE:
                    postIts.removeIf(p -> p.tableNumber == command.tableNumber);
                    break;
            }
        }

        public List<Integer> getCurrentTableNumbers() {
            return postIts.stream()
                    .map(PostIt::getTableNumber)
                    .collect(Collectors.toList());
        }
    }

    static class Command {

        private final CommandType type;
        private final int tableNumber;
        private final int time;

        private Command(CommandType type, int tableNumber, int time) {
            this.type = type;
            this.tableNumber = tableNumber;
            this.time = time;
        }

        public static Command from(String line) {
            String[] split = line.split(" ");
            CommandType type = CommandType.of(split[0]);
            int tableNumber = -1;
            int time = -1;

            if (type == CommandType.ORDER) {
                tableNumber = Integer.parseInt(split[1]);
                time = Integer.parseInt(split[2]);
            } else if (type == CommandType.COMPLETE) {
                tableNumber = Integer.parseInt(split[1]);
            }

            return new Command(type, tableNumber, time);
        }
    }

    static class Result {

        private static final String EMPTY_MESSAGE = "sleep";
        private final List<List<Integer>> history;

        public Result(List<List<Integer>> history) {
            this.history = history;
        }

        @Override
        public String toString() {
            return history.stream()
                    .map(this::format)
                    .collect(Collectors.joining("\n"));
        }

        private String format(List<Integer> tableNumbers) {
            return tableNumbers.isEmpty() ? EMPTY_MESSAGE :
                    tableNumbers.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "));
        }
    }

    static class PostIt {

        private final int tableNumber;
        private final int time;

        public PostIt(int tableNumber, int time) {
            this.tableNumber = tableNumber;
            this.time = time;
        }

        public int getTableNumber() {
            return tableNumber;
        }

        public int getTime() {
            return time;
        }
    }
}
