/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1963
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

public class PrimePath {

    private static final int MAX = 9999;
    private static final boolean[] IS_PRIME = new boolean[MAX + 1];
    private static final int[] ARRAY = {1000, 100, 10, 1};
    private static final int NOT_VISITED = -1;

    static {
        Arrays.fill(IS_PRIME, true);
        IS_PRIME[0] = IS_PRIME[1] = false;

        for (int i = 2; i <= MAX; i++) {
            if (IS_PRIME[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    IS_PRIME[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int result = solution(numbers[0], numbers[1]);
            stringBuilder
                    .append(
                            result == NOT_VISITED ? "Impossible" : result
                    ).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int start, int end) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] visited = new int[MAX + 1];
        Arrays.fill(visited, NOT_VISITED);

        queue.add(start);
        visited[start] = 0;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            for (int n : ARRAY) {
                for (int i = 0; i < 10; i++) {
                    int next = getNext(n, current, i);

                    if (next >= 1000 && IS_PRIME[next] &&
                            visited[next] == NOT_VISITED) {
                        visited[next] = visited[current] + 1;
                        queue.add(next);
                    }
                }
            }
        }

        return visited[end] == NOT_VISITED ? -1 : visited[end];
    }

    private static int getNext(int n, Integer current, int i) {
        return current - (current / n % 10) * n + i * n;
    }
}
