/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 18258
 * Cheat Level: 0
 * Algorithm: Deque
 */

package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class QueueProblem2 {

    static final String PUSH = "push";
    static final String POP = "pop";
    static final String SIZE = "size";
    static final String EMPTY = "empty";
    static final String FRONT = "front";
    static final String BACK = "back";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        QueueImpl2 queueImpl = new QueueImpl2();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            String[] actions = bufferedReader.readLine().split(" ");
            String action = actions[0];
            switch (action) {
                case PUSH:
                    int value = Integer.parseInt(actions[1]);
                    queueImpl.push(value);
                    break;
                case POP:
                    stringBuilder.append(queueImpl.pop()).append("\n");
                    break;
                case SIZE:
                    stringBuilder.append(queueImpl.size()).append("\n");
                    break;
                case EMPTY:
                    stringBuilder.append(queueImpl.empty()).append("\n");
                    break;
                case FRONT:
                    stringBuilder.append(queueImpl.front()).append("\n");
                    break;
                case BACK:
                    stringBuilder.append(queueImpl.back()).append("\n");
                    break;
            }
        }
        System.out.println(stringBuilder);
    }
}

class QueueImpl2 {

    Deque<Integer> deque;

    public QueueImpl2() {
        this.deque = new LinkedList<>();
    }

    public void push(int value) {
        this.deque.add(value);
    }

    public int pop() {
        return this.size() == 0 ? -1 : this.deque.remove();
    }

    public int size() {
        return this.deque.size();
    }

    public int empty() {
        return this.deque.isEmpty() ? 1 : 0;
    }

    public int front() {
        return this.size() == 0 ? -1 : this.deque.getFirst();
    }

    public int back() {
        return this.size() == 0 ? -1 : this.deque.getLast();
    }
}
