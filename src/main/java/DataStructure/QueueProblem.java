/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10845
 * Cheat Level: 0
 * Algorithm: Queue
 */

package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class QueueProblem {
    static final String PUSH = "push";
    static final String POP = "pop";
    static final String SIZE = "size";
    static final String EMPTY = "empty";
    static final String FRONT = "front";
    static final String BACK = "back";


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        QueueImpl queueImpl = new QueueImpl();

        for (int i = 0; i < length; i++) {
            String[] actions = bufferedReader.readLine().split(" ");
            String action = actions[0];
            switch (action) {
                case PUSH:
                    int value = Integer.parseInt(actions[1]);
                    queueImpl.push(value);
                    break;
                case POP:
                    System.out.println(queueImpl.pop());
                    break;
                case SIZE:
                    System.out.println(queueImpl.size());
                    break;
                case EMPTY:
                    System.out.println(queueImpl.empty());
                    break;
                case FRONT:
                    System.out.println(queueImpl.front());
                    break;
                case BACK:
                    System.out.println(queueImpl.back());
                    break;
            }
        }
    }
}

class QueueImpl {

    Queue<Integer> queue;
    int last;

    public QueueImpl() {
        this.queue = new LinkedList<>();
    }

    public void push(int value) {
        this.queue.add(value);
        this.last = value;
    }

    public int pop() {
        return this.size() == 0 ? -1 : this.queue.remove();
    }

    public int size() {
        return this.queue.size();
    }

    public int empty() {
        return this.queue.isEmpty() ? 1 : 0;
    }

    public int front() {
        return this.size() == 0 ? -1 : this.queue.element();
    }

    public int back() {
        return this.size() == 0 ? -1 : this.last;
    }
}
