/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2252
 * Cheat Level: 3
 * Algorithm: Graph / Topological Sort
 */

package graph.topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LineUp {

    static int N, M;
    static List<Integer>[] adjancencyList;
    static int[] inDegree;

    public static void main(String[] args) throws IOException {
        init();
        List<Integer> result = solution();
        print(result);
    }

    private static List<Integer> solution() {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) if (inDegree[i] == 0) queue.add(i);

        while (!queue.isEmpty()) {
            Integer out = queue.poll();
            result.add(out);
            for (Integer in : adjancencyList[out]) {
                inDegree[in]--;
                if (inDegree[in] == 0) queue.add(in);
            }
        }

        return result;
    }

    private static void print(List<Integer> result) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : result) stringBuilder.append(integer).append(" ");
        System.out.println(stringBuilder);
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        M = info[1];
        adjancencyList = new List[N + 1];
        inDegree = new int[N + 1];
        for (int i = 1; i <= N; i++) adjancencyList[i] = new java.util.ArrayList<>();
        for (int i = 0; i < M; i++) {
            int[] edge = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            adjancencyList[edge[0]].add(edge[1]);
            inDegree[edge[1]]++;
        }
    }
}
