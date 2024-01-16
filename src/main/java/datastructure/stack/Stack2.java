/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 28278
 * Cheat Level: 0
 * Algorithm: Stack
 */

package datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Stack2 {

    static final String PUSH = "1";
    static final String POP = "2";
    static final String SIZE = "3";
    static final String EMPTY = "4";
    static final String TOP = "5";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int commandCount = Integer.parseInt(bufferedReader.readLine());
        List<String> commandList = new ArrayList<>();
        while (commandCount-- > 0) commandList.add(bufferedReader.readLine());

        solution(commandList);
    }

    private static void solution(List<String> commandList) {
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (String command : commandList) {
            switch (command.split(" ")[0]) {
                case PUSH:
                    stack.push(Integer.parseInt(command.split(" ")[1]));
                    break;
                case POP:
                    stringBuilder.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
                    break;
                case SIZE:
                    stringBuilder.append(stack.size()).append("\n");
                    break;
                case EMPTY:
                    stringBuilder.append(stack.isEmpty() ? 1 : 0).append("\n");
                    break;
                case TOP:
                    stringBuilder.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
                    break;
                default:
                    break;
            }
        }

        System.out.print(stringBuilder.toString().trim());
    }
}
