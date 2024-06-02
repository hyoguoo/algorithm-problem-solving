/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17204
 * Cheat Level: 0
 * Algorithm: Graph / DFS
 */

package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TheGameOfDeath {

    private static final int START_INDEX = 0;
    private static final int NOT_FOUND = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sizeN = info[0];
        int target = info[1];
        int[] graph = new int[sizeN];
        for (int n = 0; n < sizeN; n++) {
            graph[n] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(solution(graph, target));
    }

    private static int solution(int[] graph, int target) {
        return dfs(graph, target, START_INDEX, 0, new boolean[graph.length]);
    }

    private static int dfs(int[] graph, int target, int index, int depth, boolean[] visited) {
        if (index == target) {
            return depth;
        }
        if (visited[index]) {
            return NOT_FOUND;
        }
        visited[index] = true;

        return dfs(graph, target, graph[index], depth + 1, visited);
    }
}
