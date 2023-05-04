/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2668
 * Cheat Level: 0
 * Algorithm: Graph / DFS
 */

package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PickNumber {

    final static List<Integer> resultList = new ArrayList<>();
    static boolean[] visited;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        graph = new int[length + 1][length + 1];
        visited = new boolean[length + 1];

        for (int i = 1; i <= length; i++) {
            int input = Integer.parseInt(bufferedReader.readLine());
            if (i == input) resultList.add(i);
            else graph[i][input] = 1;
        }

        for (int i = 1; i <= length; i++) {
            if (resultList.contains(i)) continue;
            dfs(i, i);
        }

        printResult();
    }

    private static void printResult() {
        Collections.sort(resultList);
        System.out.println(resultList.size());
        for (Integer integer : resultList) System.out.println(integer);
    }

    private static void dfs(int start, int current) {
        if (start == current && visited[current]) {
            resultList.add(start);
            return;
        }

        for (int i = 1; i < graph.length; i++) {
            if (graph[current][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(start, i);
                visited[i] = false;
            }
        }
    }
}
