/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10773
 * Cheat Level: 0
 * Algorithm: Stack
 */

package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Zero {

    static final int POP = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            int number = Integer.parseInt(bufferedReader.readLine());
            if (number == POP) stack.pop();
            else stack.push(number);
        }

        System.out.println(sumStack(stack));
    }

    private static int sumStack(Stack<Integer> stack) {
        int sum = 0;
        for (Integer integer : stack) sum += integer;

        return sum;
    }
}
