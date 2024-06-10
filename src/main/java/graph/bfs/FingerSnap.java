/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17394
 * Cheat Level: 0
 * Algorithm: Graph / BFS / Mathematics
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.function.IntUnaryOperator;

public class FingerSnap {

    private static final int MAX = 1_000_000 * 3;
    private static final int NOT_VISITED = -1;
    private static final int NOT_FOUND = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();
        while (testCount-- > 0) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            stringBuilder.append(solution(info[0], info[1], info[2])).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int origin, int lower, int upper) {
        Deque<Node> deque = new ArrayDeque<>();
        boolean[] isNotPrime = calculateNonPrimes(upper);
        int[] visited = initializeVisitedArray();

        deque.add(new Node(origin, 0));
        visited[origin] = 0;

        while (!deque.isEmpty()) {
            Node current = deque.poll();

            if (current.isInRange(lower, upper) && !isNotPrime[current.value]) {
                return current.depth;
            }

            visitNext(visited, deque, current, x -> x / 2);
            visitNext(visited, deque, current, x -> x / 3);
            visitNext(visited, deque, current, x -> x + 1);
            visitNext(visited, deque, current, x -> x - 1);
        }

        return NOT_FOUND;
    }

    private static void visitNext(
            int[] visited,
            Deque<Node> deque,
            Node current,
            IntUnaryOperator operation
    ) {
        int newValue = operation.applyAsInt(current.value);
        if ((0 <= newValue && newValue < visited.length) &&
                (visited[newValue] == NOT_VISITED || current.depth + 1 < visited[newValue])
        ) {
            deque.add(new Node(newValue, current.depth + 1));
            visited[newValue] = current.depth + 1;
        }
    }

    private static int[] initializeVisitedArray() {
        int[] visited = new int[MAX + 1];

        Arrays.fill(visited, NOT_VISITED);

        return visited;
    }

    private static boolean[] calculateNonPrimes(int upper) {
        boolean[] isNotPrime = new boolean[upper + 1];

        for (int i = 2; i <= upper; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            for (int j = i * 2; j <= upper; j += i) {
                isNotPrime[j] = true;
            }
        }

        return isNotPrime;
    }


    static class Node {

        int value;
        int depth;

        public Node(int value, int depth) {
            this.value = value;
            this.depth = depth;
        }

        public boolean isInRange(int lower, int upper) {
            return lower <= this.value && this.value <= upper;
        }
    }
}
