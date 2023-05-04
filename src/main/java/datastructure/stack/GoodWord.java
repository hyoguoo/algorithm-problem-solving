/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3986
 * Cheat Level: 0
 * Algorithm: Stack
 */

package datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class GoodWord {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        int count = 0;
        for (int i = 0; i < length; i++) {
            String input = bufferedReader.readLine();
            if (solution(input)) count++;
        }
        System.out.println(count);
    }

    private static boolean solution(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (stack.isEmpty()) stack.push(current);
            else {
                if (stack.peek() == current) stack.pop();
                else stack.push(current);
            }
        }

        return stack.isEmpty();
    }
}

/*
3 2 1 -3 -1
2 1 -3 3 -1
1 -3 2 3 -1
-3 1 2 3 -1
1 2 -3 3 -1
1 2 3 -1 -3


 */