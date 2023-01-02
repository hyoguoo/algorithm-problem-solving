/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10828
 * Cheat Level: 0
 * Algorithm: Stack
 */

package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackProblem {
    static final String PUSH = "push";
    static final String POP = "pop";
    static final String SIZE = "size";
    static final String EMPTY = "empty";
    static final String TOP = "top";


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        StackImpl stackImpl = new StackImpl();
        for (int i = 0; i < length; i++) {
            String[] actions = bufferedReader.readLine().split(" ");
            String action = actions[0];
            switch (action) {
                case PUSH:
                    int value = Integer.parseInt(actions[1]);
                    stackImpl.push(value);
                    break;
                case POP:
                    System.out.println(stackImpl.pop());
                    break;
                case SIZE:
                    System.out.println(stackImpl.size());
                    break;
                case EMPTY:
                    System.out.println(stackImpl.empty());
                    break;
                case TOP:
                    System.out.println(stackImpl.top());
                    break;
            }
        }
    }
}

class StackImpl {

    Stack<Integer> stack;

    public StackImpl() {
        this.stack = new Stack<>();
    }

    public void push(int value) {
        this.stack.push(value);
    }

    public int pop() {
        return this.size() == 0 ? -1 : this.stack.pop();
    }

    public int top() {
        return this.size() == 0 ? -1 : this.stack.peek();
    }

    public int size() {
        return this.stack.size();
    }

    public int empty() {
        return this.stack.isEmpty() ? 1 : 0;
    }
}