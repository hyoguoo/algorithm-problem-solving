/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9019
 * Cheat Level: 1
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DSLR {

    final static String[] COMMANDS_LIST = {"D", "S", "L", "R"};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < length; i++) {
            int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(bfs(numbers[0], numbers[1]));
        }
    }

    private static String bfs(int src, int dist) {
        String[] commands = new String[10000];
        Queue<Number> queue = new LinkedList<>();
        queue.add(new Number(src, ""));

        while (!queue.isEmpty()) {
            Number currentNumber = queue.poll();

            for (String command : COMMANDS_LIST) {
                int number = calculate(currentNumber.number, command);
                if (commands[number] == null) {
                    commands[number] = currentNumber.command + command;
                    queue.add(new Number(number, commands[number]));
                }
            }
        }

        return commands[dist];
    }

    private static int calculate(int number, String command) {
        switch (command) {
            case "D":
                return (number * 2) % 10000;
            case "S":
                return number == 0 ? 9999 : number - 1;
            case "L":
                return (number % 1000) * 10 + number / 1000;
            case "R":
                return (number % 10) * 1000 + number / 10;
        }
        throw new IllegalArgumentException();
    }
}

class Number {
    int number;
    String command;

    public Number(int number, String command) {
        this.number = number;
        this.command = command;
    }
}
