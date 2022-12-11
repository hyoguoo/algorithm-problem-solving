/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1260
 */

package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFSandBFS {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] infos = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int vertexCount = infos[0];
        int edgeCount = infos[1];
        int startVertex = infos[2];

        int[][] edges = new int[vertexCount + 1][vertexCount + 1];
        for (int i = 0; i < edgeCount; i++) {
            int[] edge = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            edges[edge[0]][edge[1]] = 1;
            edges[edge[1]][edge[0]] = 1;
        }

        printResult(dfs(edges, startVertex));
        printResult(bfs(edges, startVertex));
    }

    private static void printResult(List<Integer> result) {
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i != result.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    private static List<Integer> dfs(int[][] edges, int startVertex) {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[edges.length];

        stack.push(startVertex);
        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();
            if (!visited[currentVertex]) result.add(currentVertex);
            visited[currentVertex] = true;
            for (int i = edges.length - 1; i > 0; i--) {
                if (edges[currentVertex][i] == 1 && !visited[i]) stack.push(i);
            }
        }

        return result;
    }

    private static List<Integer> bfs(int[][] edges, int startVertex) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[edges.length];

        queue.add(startVertex);
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            if (!visited[currentVertex]) result.add(currentVertex);
            visited[currentVertex] = true;
            for (int i = 1; i < edges.length; i++) {
                if (edges[currentVertex][i] == 1 && !visited[i]) queue.add(i);
            }
        }

        return result;
    }
}
