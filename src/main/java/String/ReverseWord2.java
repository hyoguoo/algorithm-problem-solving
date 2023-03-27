/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17413
 * Cheat Level: 0
 * Algorithm: String
 */

package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ReverseWord2 {

    final static char SPACE = ' ';
    final static char LEFT_BRACKET = '<';
    final static char RIGHT_BRACKET = '>';

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        System.out.println(solution(input));
    }

    private static String solution(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == LEFT_BRACKET) {
                while (!stack.isEmpty()) stringBuilder.append(stack.pop());
                stringBuilder.append(c);
                while (input.charAt(++i) != RIGHT_BRACKET) stringBuilder.append(input.charAt(i));
                stringBuilder.append(input.charAt(i));
            } else if (c == SPACE) {
                while (!stack.isEmpty()) stringBuilder.append(stack.pop());
                stringBuilder.append(c);
            } else {
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) stringBuilder.append(stack.pop());

        return stringBuilder.toString();
    }
}
