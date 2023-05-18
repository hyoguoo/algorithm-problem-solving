/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1005
 * Cheat Level: 2
 * Algorithm: Graph / Topological Sort / Dynamic Programming
 */

package graph.topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ACMCraft {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < testCount; i++) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int vertexCount = info[0];
            int edgeCount = info[1];

            List<Edge>[] adjancencyList = getAdjacencyList(vertexCount);
            int[] inDegree = new int[vertexCount + 1];
            int[] costs = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int edge = 1; edge <= edgeCount; edge++) {
                int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                adjancencyList[edgeInfo[0]].add(new Edge(edgeInfo[1], costs[edgeInfo[1] - 1]));
                inDegree[edgeInfo[1]]++;
            }

            int target = Integer.parseInt(bufferedReader.readLine());
            System.out.println(solution(adjancencyList, inDegree, costs, target));
        }
    }

    private static List<Edge>[] getAdjacencyList(int vertexCount) {
        List<Edge>[] adjancencyList = new List[vertexCount + 1];
        for (int vertex = 1; vertex <= vertexCount; vertex++) adjancencyList[vertex] = new ArrayList<>();
        return adjancencyList;
    }

    private static int solution(List<Edge>[] adjancencyList, int[] inDegree, int[] costs, int target) {
        Queue<Integer> queue = new LinkedList<>();
        int[] dp = new int[inDegree.length];
        for (int i = 1; i < dp.length; i++) dp[i] = costs[i - 1];
        for (int i = 1; i < inDegree.length; i++) if (inDegree[i] == 0) queue.add(i);

        while (!queue.isEmpty()) {
            Integer from = queue.poll();
            for (Edge edge : adjancencyList[from]) {
                dp[edge.to] = Math.max(dp[edge.to], dp[from] + edge.cost);
                inDegree[edge.to]--;
                if (inDegree[edge.to] == 0) queue.add(edge.to);
            }
        }

        return dp[target];
    }

    static class Edge {
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
