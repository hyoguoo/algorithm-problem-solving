/*
 * goormlevel
 * https://level.goorm.io
 * Goormthon Challenge: 17일차
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TelecommunicationNetworkAnalysis {

    static int totalVertexCount, totalEdgeCount;
    static List<Integer>[] edgeList;


    public static void main(String[] args) throws Exception {
        init();
        printList(solution());
    }

    private static List<Integer> solution() {
        boolean[] visited = new boolean[totalVertexCount + 1];
        List<Network> networkList = new ArrayList<>();

        for (int v = 1; v <= totalVertexCount; v++) {
            if (!visited[v]) networkList.add(bfs(v, visited));
        }

        Collections.sort(networkList);
        Collections.sort(networkList.get(0).vertexList);
        return networkList.get(0).vertexList;
    }

    private static Network bfs(int startVertex, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);

        List<Integer> vertexList = new ArrayList<>();
        int edge = 0;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            if (visited[current]) continue;
            visited[current] = true;
            vertexList.add(current);

            for (Integer next : edgeList[current]) {
                queue.add(next);
                edge++;
            }
        }

        return new Network(edge, vertexList);
    }

    private static void printList(List<Integer> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int n : list) stringBuilder.append(n).append(" ");
        System.out.println(stringBuilder);
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        totalVertexCount = info[0];
        totalEdgeCount = info[1];
        edgeList = new ArrayList[totalVertexCount + 1];
        for (int i = 0; i < edgeList.length; i++) edgeList[i] = new ArrayList<>();
        for (int i = 0; i < totalEdgeCount; i++) {
            int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int from = edgeInfo[0];
            int to = edgeInfo[1];
            edgeList[from].add(to);
            edgeList[to].add(from);
        }
    }

    static class Network implements Comparable<Network> {

        int edgeCount;
        List<Integer> vertexList;

        public Network(int edgeCount, List<Integer> vertexList) {
            this.edgeCount = edgeCount;
            this.vertexList = vertexList;
        }

        @Override
        public int compareTo(Network o) {
            double oDensity = (double) o.edgeCount / o.vertexList.size();
            double thisDensity = (double) this.edgeCount / this.vertexList.size();
            if (Double.compare(oDensity, thisDensity) != 0) return Double.compare(oDensity, thisDensity);

            return Collections.min(this.vertexList) - Collections.min(o.vertexList);
        }
    }
}
