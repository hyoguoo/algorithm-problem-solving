/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1362
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pet {

    private static final String COMMAND_END_SIGN = "# 0";
    private static final String PET_END_SIGN = "0 0";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int testCase = 1;
        while (true) {
            String petInfoInput = bufferedReader.readLine();
            if (petInfoInput.equals(PET_END_SIGN)) {
                break;
            }
            int[] petInfo = Arrays.stream(petInfoInput.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            PetStatus petStatus = new PetStatus(petInfo[0], petInfo[1]);

            List<Command> commandList = new ArrayList<>();
            while (true) {
                String commandInput = bufferedReader.readLine();
                if (commandInput.equals(COMMAND_END_SIGN)) {
                    break;
                }
                String[] commandInfo = commandInput.split(" ");
                commandList.add(new Command(commandInfo[0], Integer.parseInt(commandInfo[1])));
            }

            stringBuilder
                    .append(String.format("%d ", testCase++))
                    .append(solution(petStatus, commandList))
                    .append(System.lineSeparator());
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static Mood solution(PetStatus petStatus, List<Command> commandList) {
        for (Command command : commandList) {
            petStatus.currentWeight = command.action.changeValue(petStatus.currentWeight, command.amount);
            if (petStatus.getMood() == Mood.DEAD) {
                return Mood.DEAD;
            }
        }
        return petStatus.getMood();
    }

    enum Action {
        FEED("F", Integer::sum),
        EXERCISE("E", (v, a) -> v - a);

        private final String command;
        private final ValueChanger valueChanger;

        Action(String command, ValueChanger valueChanger) {
            this.command = command;
            this.valueChanger = valueChanger;
        }

        public static Action fromCommand(String command) {
            return Arrays.stream(values())
                    .filter(action -> action.command.equals(command))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }

        public int changeValue(int currentValue, int amount) {
            return valueChanger.change(currentValue, amount);
        }
    }

    enum Mood {
        HAPPY(":-)"),
        SAD(":-("),
        DEAD("RIP");

        private final String emoticon;

        Mood(String emoticon) {
            this.emoticon = emoticon;
        }

        @Override
        public String toString() {
            return emoticon;
        }
    }

    @FunctionalInterface
    interface ValueChanger {

        int change(int currentValue, int amount);
    }

    static class Command {

        private final Action action;
        private final int amount;

        public Command(String command, int amount) {
            this.action = Action.fromCommand(command);
            this.amount = amount;
        }
    }

    static class PetStatus {

        private final int properWeight;
        private int currentWeight;

        public PetStatus(int properWeight, int currentWeight) {
            this.properWeight = properWeight;
            this.currentWeight = currentWeight;
        }

        public Mood getMood() {
            if (currentWeight <= 0) {
                return Mood.DEAD;
            }
            if (properWeight / 2.0 < currentWeight &&
                    currentWeight < properWeight * 2.0) {
                return Mood.HAPPY;
            }
            return Mood.SAD;
        }
    }
}
