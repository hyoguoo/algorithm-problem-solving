/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5567
 * Cheat Level: 0
 * Algorithm: Graph
 */

package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Weddings {

    static final int ME = 1;
    static final int DEPTH_LIMIT = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int vertexCount = Integer.parseInt(bufferedReader.readLine());
        int edgeCount = Integer.parseInt(bufferedReader.readLine());
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int e = 0; e < edgeCount; e++) {
            int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.computeIfAbsent(edgeInfo[0], v -> new ArrayList<>()).add(edgeInfo[1]);
            graph.computeIfAbsent(edgeInfo[1], v -> new ArrayList<>()).add(edgeInfo[0]);
        }

        System.out.println(solution(graph, vertexCount));
    }

    private static int solution(Map<Integer, List<Integer>> graph, int vertexCount) {
        boolean[] visited = new boolean[vertexCount + 1];
        Queue<Friend> queue = new LinkedList<>();
        queue.add(new Friend(ME, 0));
        visited[ME] = true;

        int answer = 0;

        while (!queue.isEmpty()) {
            Friend current = queue.poll();
            if (current.depth >= DEPTH_LIMIT) break;

            for (int next : graph.getOrDefault(current.index, new ArrayList<>())) {
                if (visited[next]) continue;

                visited[next] = true;
                queue.add(new Friend(next, current.depth + 1));
                answer++;
            }
        }

        return answer;
    }

    static class Friend {
        int index;
        int depth;

        public Friend(int index, int depth) {
            this.index = index;
            this.depth = depth;
        }
    }
}
