/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16120
 * Cheat Level: 2
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PPAP {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        System.out.println(solution(input) ? "PPAP" : "NP");
    }

    private static boolean solution(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            stack.push(c);
            if (stack.size() < 4) continue;
            if (popPPAP(stack)) stack.push('P');
        }

        return stack.size() == 1 && stack.peek() == 'P';
    }

    private static boolean popPPAP(Stack<Character> stack) {
        StringBuilder temp = new StringBuilder();

        for (int j = stack.size() - 1; j >= stack.size() - 4; j--) {
            temp.append(stack.get(j));
            if (temp.toString().equals("PAPP")) {
                for (int k = 0; k < 4; k++) stack.pop();
                return true;
            }
        }

        return false;
    }
}
