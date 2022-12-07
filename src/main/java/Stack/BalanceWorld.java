/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4949
 */

package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalanceWorld {

    private static final String EXIT = ".";


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = bufferedReader.readLine();
            if (input.equals(EXIT)) break;
            System.out.println(isBalanced(input) ? "yes" : "no");
        }
    }

    private static boolean isBalanced(String input) {
        String bracket = input.replaceAll("[^\\[\\]()]", "");
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < bracket.length(); i++) {
            char current = bracket.charAt(i);
            if (current == '(' || current == '[') stack.push(current);
            else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (current == ')' && top != '(') return false;
                if (current == ']' && top != '[') return false;
            }
        }

        return stack.isEmpty();
    }
}
