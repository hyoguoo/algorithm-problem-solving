/*
 * goormlevel
 * https://level.goorm.io
 * Goormthon Challenge: 14일차
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SmallNode {

    static int NODE_COUNT, EDGE_COUNT, START_NODE;
    static List<Integer>[] edgeList;

    public static void main(String[] args) throws Exception {
        init();
        solution();
    }

    private static void solution() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(START_NODE);

        boolean[] visited = new boolean[NODE_COUNT + 1];
        int visitCount = 0;
        int lastNode = START_NODE;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            visited[current] = true;
            visitCount++;
            lastNode = current;

            List<Integer> edge = edgeList[current];
            for (int node : edge) {
                if (visited[node]) continue;
                queue.add(node);
                break;
            }
        }

        System.out.println(visitCount + " " + lastNode);
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        NODE_COUNT = info[0];
        EDGE_COUNT = info[1];
        START_NODE = info[2];
        edgeList = new ArrayList[NODE_COUNT + 1];
        for (int n = 0; n < NODE_COUNT + 1; n++) edgeList[n] = new ArrayList<>();
        for (int e = 0; e < EDGE_COUNT; e++) {
            int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            edgeList[edgeInfo[0]].add(edgeInfo[1]);
            edgeList[edgeInfo[1]].add(edgeInfo[0]);
        }
        for (int n = 0; n < NODE_COUNT + 1; n++) Collections.sort(edgeList[n]);
    }
}
