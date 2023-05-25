/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1766
 * Cheat Level: 0
 * Algorithm: Graph / Topological Sort/ Priority Queue
 */

package graph.topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Workbook {

    static List<Integer>[] adjacencyList;
    static int VERTEX_COUNT, EDGE_COUNT;
    static int[] inDegree;

    public static void main(String[] args) throws IOException {
        init();
        print(solution());
    }

    private static List<Integer> solution() {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 1; i <= VERTEX_COUNT; i++) if (inDegree[i] == 0) queue.add(i);

        while (!queue.isEmpty()) {
            Integer out = queue.poll();
            result.add(out);
            for (Integer in : adjacencyList[out]) {
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

        VERTEX_COUNT = info[0];
        EDGE_COUNT = info[1];
        inDegree = new int[VERTEX_COUNT + 1];
        adjacencyList = new ArrayList[VERTEX_COUNT + 1];

        for (int i = 1; i <= VERTEX_COUNT; i++) adjacencyList[i] = new ArrayList<>();
        for (int i = 0; i < EDGE_COUNT; i++) {
            int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            adjacencyList[edgeInfo[0]].add(edgeInfo[1]);
            inDegree[edgeInfo[1]]++;
        }
    }
}
