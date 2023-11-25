/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5397
 * Cheat Level: 0
 * Algorithm: Stack
 */

package datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Keylogger {

    static final char LEFT = '<';
    static final char RIGHT = '>';
    static final char BACKSPACE = '-';

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();
        while (testCount-- > 0) {
            stringBuilder.append(solution(bufferedReader.readLine().toCharArray())).append("\n");
        }
        System.out.print(stringBuilder);
    }

    private static String solution(char[] input) {
        Deque<Character> leftStack = new ArrayDeque<>();
        Deque<Character> rightStack = new ArrayDeque<>();

        for (char c : input) {
            switch (c) {
                case LEFT:
                    if (!leftStack.isEmpty()) rightStack.push(leftStack.pop());
                    break;
                case RIGHT:
                    if (!rightStack.isEmpty()) leftStack.push(rightStack.pop());
                    break;
                case BACKSPACE:
                    if (!leftStack.isEmpty()) leftStack.pop();
                    break;
                default:
                    leftStack.push(c);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!leftStack.isEmpty()) {
            stringBuilder.append(leftStack.pop());
        }
        stringBuilder.reverse();
        for (Character character : rightStack) {
            stringBuilder.append(character);
        }

        return stringBuilder.toString();
    }
}
