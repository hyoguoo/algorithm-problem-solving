/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 13023
 * Cheat Level: 2
 * Algorithm: Graph
 */

package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ABCDE {

    final static int MAX_DEPTH = 4;
    static int VERTEX;
    static int EDGE;
    static List<Integer>[] edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        VERTEX = info[0];
        EDGE = info[1];
        setListArray();

        for (int i = 0; i < EDGE; i++) {
            int[] edge = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int start = edge[0];
            int end = edge[1];
            edgeList[start].add(end);
            edgeList[end].add(start);
        }

        System.out.println(solution() ? 1 : 0);
    }

    private static void setListArray() {
        edgeList = new ArrayList[VERTEX];
        for (int i = 0; i < VERTEX; i++) edgeList[i] = new ArrayList<>();
    }

    private static boolean solution() {
        for (int i = 0; i < VERTEX; i++) {
            if (dfs(i, 0, new boolean[VERTEX])) return true;
        }
        return false;
    }

    private static boolean dfs(int vertex, int depth, boolean[] visited) {
        if (depth == MAX_DEPTH) return true;
        for (int i = 0; i < edgeList[vertex].size(); i++) {
            int next = edgeList[vertex].get(i);
            if (visited[next]) continue;
            visited[vertex] = true;
            if (dfs(next, depth + 1, visited)) return true;
            visited[vertex] = false;
        }
        return false;
    }
}

