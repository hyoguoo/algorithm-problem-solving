/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2644
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CountingCounts {

    static final int NOT_VISIT = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] startEnd = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int start = startEnd[0];
        int end = startEnd[1];
        List<Integer>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        int m = Integer.parseInt(bufferedReader.readLine());
        while (m-- > 0) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = info[0];
            int b = info[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        System.out.println(solution(graph, start, end));
    }

    private static int solution(List<Integer>[] graph, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visit = new int[graph.length];
        Arrays.fill(visit, NOT_VISIT);
        queue.add(start);
        visit[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == end) return visit[current];

            for (Integer to : graph[current]) {
                if (visit[to] == NOT_VISIT) {
                    queue.add(to);
                    visit[to] = visit[current] + 1;
                }
            }
        }

        return visit[end];
    }
}
