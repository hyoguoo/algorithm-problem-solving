/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10866
 * Cheat Level: 0
 * Algorithm: Deque
 */

package datastructure.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class DequeProblem {

    static final String PUSH_FRONT = "push_front";
    static final String PUSH_BACK = "push_back";
    static final String POP_FRONT = "pop_front";
    static final String POP_BACK = "pop_back";
    static final String SIZE = "size";
    static final String EMPTY = "empty";
    static final String FRONT = "front";
    static final String BACK = "back";


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        DequeImpl queueImpl = new DequeImpl();

        for (int i = 0; i < length; i++) {
            String[] actions = bufferedReader.readLine().split(" ");
            String action = actions[0];
            switch (action) {
                case PUSH_FRONT:
                    queueImpl.pushFront(Integer.parseInt(actions[1]));
                    break;
                case PUSH_BACK:
                    queueImpl.pushBack(Integer.parseInt(actions[1]));
                    break;
                case POP_FRONT:
                    System.out.println(queueImpl.popFront());
                    break;
                case POP_BACK:
                    System.out.println(queueImpl.popBack());
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


class DequeImpl {
    Deque<Integer> deque;

    public DequeImpl() {
        this.deque = new ArrayDeque<>();
    }

    public void pushFront(int value) {
        this.deque.addFirst(value);
    }

    public void pushBack(int value) {
        this.deque.addLast(value);
    }

    public int popFront() {
        return this.deque.isEmpty() ? -1 : this.deque.removeFirst();
    }

    public int popBack() {
        return this.deque.isEmpty() ? -1 : this.deque.removeLast();
    }

    public int size() {
        return this.deque.size();
    }

    public int empty() {
        return this.deque.isEmpty() ? 1 : 0;
    }

    public int front() {
        return this.deque.isEmpty() ? -1 : this.deque.getFirst();
    }

    public int back() {
        return this.deque.isEmpty() ? -1 : this.deque.getLast();
    }
}
