/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 12761
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
import java.util.stream.IntStream;

public class StoneBridge {

    private static final int MAX_POSITION = 100_000;
    private static final int NOT_VISITED = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int powerA = info[0];
        int powerB = info[1];
        int start = info[2];
        int target = info[3];

        System.out.print(solution(start, target, powerA, powerB));
    }

    private static int solution(int start, int target, int powerA, int powerB) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        int[] dist = IntStream.range(0, MAX_POSITION + 1)
                .map(i -> NOT_VISITED)
                .toArray();
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == target) {
                return dist[current];
            }

            Arrays.stream(MoveType.values())
                    .map(moveType -> moveType.apply(current, powerA, powerB))
                    .filter(StoneBridge::isInBounds)
                    .filter(next -> dist[next] == NOT_VISITED)
                    .forEach(next -> {
                        dist[next] = dist[current] + 1;
                        queue.add(next);
                    });
        }

        return NOT_VISITED;
    }

    private static boolean isInBounds(int next) {
        return 0 <= next && next <= MAX_POSITION;
    }

    enum MoveType {
        LEFT((p, a, b) -> p - 1),
        RIGHT((p, a, b) -> p + 1),
        LEFT_A((p, a, b) -> p - a),
        RIGHT_A((p, a, b) -> p + a),
        LEFT_B((p, a, b) -> p - b),
        RIGHT_B((p, a, b) -> p + b),
        POWER_A((p, a, b) -> p * a),
        POWER_B((p, a, b) -> p * b);

        private final MoveOperation operation;

        MoveType(MoveOperation operation) {
            this.operation = operation;
        }

        public int apply(int position, int powerA, int powerB) {
            return operation.apply(position, powerA, powerB);
        }

        interface MoveOperation {

            int apply(int position, int powerA, int powerB);
        }
    }
}
