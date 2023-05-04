/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9935
 * Cheat Level: 0
 * Algorithm: String / Stack
 */

package datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StringExplosion {

    final static String EMPTY = "FRULA";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String src = bufferedReader.readLine();
        String bomb = bufferedReader.readLine();

        System.out.println(solution(src, bomb));
    }

    private static String solution(String src, String bomb) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < src.length(); i++) {
            stack.push(src.charAt(i));
            while (bomb.length() <= stack.size()) {
                if (isBomb(stack, bomb)) popStack(stack, bomb);
                else break;
            }
        }

        if (stack.isEmpty()) return EMPTY;
        return getAnswer(stack);
    }

    private static void popStack(Stack<Character> stack, String bomb) {
        for (int j = 0; j < bomb.length(); j++) stack.pop();
    }

    private static boolean isBomb(Stack<Character> stack, String bomb) {
        for (int i = 0; i < bomb.length(); i++) {
            if (stack.get(stack.size() - bomb.length() + i) != bomb.charAt(i)) return false;
        }
        return true;
    }

    private static String getAnswer(Stack<Character> stack) {
        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) answer.append(stack.pop());
        return answer.reverse().toString();
    }
}
