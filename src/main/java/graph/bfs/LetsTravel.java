package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LetsTravel {

    static final int NOT_EXIST = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int vertexCount = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.readLine();
        int[][] graph = new int[vertexCount][vertexCount];

        for (int i = 0; i < vertexCount; i++) {
            graph[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[] pathOriginal = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] path = new int[pathOriginal.length];
        for (int i = 0; i < pathOriginal.length; i++) {
            path[i] = pathOriginal[i] - 1;
        }

        System.out.println(
                solution(graph, path)
                        ? "YES"
                        : "NO"
        );
    }

    private static boolean solution(int[][] graph, int[] path) {
        final int start = path[0];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        boolean[] visited = new boolean[graph.length];
        visited[start] = true;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            for (int next = 0; next < graph.length; next++) {
                if (graph[current][next] == NOT_EXIST ||
                    visited[next]) continue;
                visited[next] = true;
                queue.add(next);
            }
        }

        return isAllVisit(path, visited);
    }

    private static boolean isAllVisit(int[] path, boolean[] visited) {
        for (int i : path) {
            if (!visited[i]) return false;
        }

        return true;
    }
}
