/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1326
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class HopHop {

    private static final int NOT_FOUND = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] steppingStoneValues = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int startPosition = info[0] - 1;
        int endPosition = info[1] - 1;

        System.out.print(solution(steppingStoneValues, startPosition, endPosition));
    }

    private static int solution(int[] steppingStoneValues, int startPosition, int endPosition) {
        Queue<State> queue = new LinkedList<>();
        boolean[] visited = new boolean[steppingStoneValues.length];
        queue.add(new State(startPosition, 0, steppingStoneValues[startPosition]));
        visited[startPosition] = true;

        while (!queue.isEmpty()) {
            State current = queue.poll();

            if (current.isAtPosition(endPosition)) {
                return current.time;
            }

            if (current.value == 0) {
                return current.time + 1;
            }

            int remain = current.position % current.value;

            for (int nextPosition = remain; nextPosition <= steppingStoneValues.length - 1;
                    nextPosition += current.value) {
                if (!visited[nextPosition]) {
                    visited[nextPosition] = true;
                    queue.add(new State(nextPosition, current.time + 1, steppingStoneValues[nextPosition]));
                }
            }
        }

        return NOT_FOUND;
    }

    static class State {

        private final int position;
        private final int time;
        private final int value;

        public State(int position, int time, int value) {
            this.position = position;
            this.time = time;
            this.value = value;
        }

        public boolean isAtPosition(int targetPosition) {
            return this.position == targetPosition;
        }
    }
}
