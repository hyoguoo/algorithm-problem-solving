/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2504
 * Cheat Level: 0
 * Algorithm: Stack
 */

package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ValueInParentheses {
    final static char OPEN_PARENTHESIS = '(';
    final static char CLOSE_PARENTHESIS = ')';
    final static char OPEN_BRACKET = '[';
    final static char CLOSE_BRACKET = ']';
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char[] brackets = bufferedReader.readLine().toCharArray();

        System.out.println(solution(brackets));

    }

    public static int solution(char[] brackets) {
        int result = 0;
        int value = 1;

        for (int i = 0; i < brackets.length; i++) {
            switch (brackets[i]) {
                case OPEN_PARENTHESIS:
                    stack.push(brackets[i]);
                    value *= 2;
                    break;
                case OPEN_BRACKET:
                    stack.push(brackets[i]);
                    value *= 3;
                    break;
                case CLOSE_PARENTHESIS:
                    if (stack.isEmpty() || stack.peek() != OPEN_PARENTHESIS) return 0;
                    if (brackets[i - 1] == OPEN_PARENTHESIS) result += value;
                    stack.pop();
                    value /= 2;
                    break;
                case CLOSE_BRACKET:
                    if (stack.isEmpty() || stack.peek() != OPEN_BRACKET) return 0;
                    if (brackets[i - 1] == OPEN_BRACKET) result += value;
                    stack.pop();
                    value /= 3;
                    break;
            }
        }
        if (!stack.isEmpty()) return 0;
        return result;
    }
}