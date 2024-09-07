/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4949
 * Cheat Level: 0
 * Algorithm: Stack / Regular Expression
 */

package datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BalanceWorld {

    private static final String EXIT = ".";
    private static final char OPEN = '(';
    private static final char CLOSE = ')';
    private static final char OPEN_BRACKET = '[';
    private static final char CLOSE_BRACKET = ']';
    private static final String BRACKET_FILTER_REGEX = String.format("[^\\%c\\%c\\%c\\%c]",
            OPEN, CLOSE, OPEN_BRACKET, CLOSE_BRACKET);

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            String input = bufferedReader.readLine();
            if (input.equals(EXIT)) {
                break;
            }
            stringBuilder.append(solution(input) ? "yes" : "no").append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static boolean solution(String input) {
        String bracket = filterBrackets(input);
        Deque<Character> deque = new ArrayDeque<>();

        for (char current : bracket.toCharArray()) {
            if (isOpenBracket(current)) {
                deque.push(current);
            } else if (deque.isEmpty() ||
                    !isMatchingPair(deque.pop(), current)) {
                return false;
            }
        }

        return deque.isEmpty();
    }

    private static boolean isOpenBracket(char c) {
        return c == OPEN || c == OPEN_BRACKET;
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == OPEN && close == CLOSE) ||
                (open == OPEN_BRACKET && close == CLOSE_BRACKET);
    }

    private static String filterBrackets(String input) {
        return input.replaceAll(BRACKET_FILTER_REGEX, "");
    }
}
