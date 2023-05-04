/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1918
 * Cheat Level: 4
 * Algorithm: Stack
 */

package datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;

public class PostfixExpression {

    final static char LEFT_PARENTHESIS = '(';
    final static char RIGHT_PARENTHESIS = ')';
    final static List<Character> LOW_OPERATOR = List.of('+', '-');
    final static List<Character> HIGH_OPERATOR = List.of('*', '/');

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(getPostfixExpression(bufferedReader.readLine()));
    }

    private static String getPostfixExpression(String expression) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] charArray = expression.toCharArray();

        for (char c : charArray) {
            if (c == LEFT_PARENTHESIS) stack.push(c);
            else if (c == RIGHT_PARENTHESIS) {
                while (!stack.isEmpty()) {
                    char operator = stack.pop();
                    if (operator == LEFT_PARENTHESIS) break;
                    stringBuilder.append(operator);
                }
            } else if (LOW_OPERATOR.contains(c)) {
                while (!stack.isEmpty()) {
                    char operator = stack.peek();
                    if (operator == LEFT_PARENTHESIS) break;
                    stringBuilder.append(stack.pop());
                }
                stack.push(c);
            } else if (HIGH_OPERATOR.contains(c)) {
                while (!stack.isEmpty()) {
                    char operator = stack.peek();
                    if (operator == LEFT_PARENTHESIS || LOW_OPERATOR.contains(operator)) break;
                    stringBuilder.append(stack.pop());
                }
                stack.push(c);
            } else stringBuilder.append(c);
        }

        while (!stack.isEmpty()) stringBuilder.append(stack.pop());

        return stringBuilder.toString();
    }
}
