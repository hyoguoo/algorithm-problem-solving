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
import java.util.Stack;

public class Editor {

    static final Stack<Character> leftStack = new Stack<>();
    static final Stack<Character> rightStack = new Stack<>();
    static final char LEFT = 'L';
    static final char RIGHT = 'D';
    static final char DELETE = 'B';
    static final char INSERT = 'P';

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char[] input = bufferedReader.readLine().toCharArray();
        for (char c : input) leftStack.add(c);
        int commandCount = Integer.parseInt(bufferedReader.readLine());

        while (commandCount-- > 0) {
            char[] command = bufferedReader.readLine().toCharArray();
            action(command);
        }

        printResult();
    }

    private static void action(char[] command) {
        switch (command[0]) {
            case LEFT:
                if (leftStack.isEmpty()) break;
                rightStack.push(leftStack.pop());
                break;
            case RIGHT:
                if (rightStack.isEmpty()) break;
                leftStack.push(rightStack.pop());
                break;
            case DELETE:
                if (leftStack.isEmpty()) break;
                leftStack.pop();
                break;
            case INSERT:
                leftStack.push(command[2]);
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    private static void printResult() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : leftStack) stringBuilder.append(character);
        while (!rightStack.isEmpty()) stringBuilder.append(rightStack.pop());
        System.out.print(stringBuilder);
    }
}
