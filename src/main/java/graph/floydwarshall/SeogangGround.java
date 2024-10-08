/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14938
 * Cheat Level: 0
 * Algorithm: Graph / Floyd-Warshall
 */

package graph.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SeogangGround {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int vertexCount = info[0];
        int distanceLimit = info[1];
        int edgeCount = info[2];
        int[][] graph = new int[vertexCount + 1][vertexCount + 1];
        int[] items = new int[vertexCount + 1];
        int[] itemInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.arraycopy(itemInfo, 0, items, 1, vertexCount);
        for (int i = 0; i < edgeCount; i++) {
            int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            graph[edgeInfo[0]][edgeInfo[1]] = edgeInfo[2];
            graph[edgeInfo[1]][edgeInfo[0]] = edgeInfo[2];
        }

        System.out.print(solution(graph, items, distanceLimit));
    }

    private static int solution(int[][] graph, int[] items, int distanceLimit) {
        int[][] distances = calculateDistance(graph);

        int[] maxItems = getMaxItemByVertex(distances, items, distanceLimit);

        return Arrays.stream(maxItems).max().orElseThrow();
    }

    private static int[][] calculateDistance(int[][] graph) {
        int[][] distances = initDistance(graph);

        for (int k = 1; k < graph.length; k++) {
            for (int i = 1; i < graph.length; i++) {
                for (int j = 1; j < graph.length; j++) {
                    if (distances[i][k] != Integer.MAX_VALUE && distances[k][j] != Integer.MAX_VALUE) {
                        distances[i][j] = Math.min(distances[i][j], distances[i][k] + distances[k][j]);
                    }
                }
            }
        }
        return distances;
    }

    private static int[][] initDistance(int[][] graph) {
        int[][] distances = new int[graph.length][graph.length];

        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph.length; j++) {
                if (i == j) {
                    distances[i][j] = 0;
                } else if (graph[i][j] != 0) {
                    distances[i][j] = graph[i][j];
                } else {
                    distances[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        return distances;
    }

    private static int[] getMaxItemByVertex(int[][] distances, int[] items, int distanceLimit) {
        int[] maxItems = new int[items.length];

        for (int i = 1; i < items.length; i++) {
            for (int j = 1; j < items.length; j++) {
                if (distances[i][j] <= distanceLimit) {
                    maxItems[i] += items[j];
                }
            }
        }

        return maxItems;
    }
}
