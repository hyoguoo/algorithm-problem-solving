/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 92025
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WalkingDrinking {

    static final int LIMIT = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        while (testCount-- > 0) {
            int nodeCount = Integer.parseInt(bufferedReader.readLine()) + 2;
            Coordinate[] coordinates = new Coordinate[nodeCount];
            for (int i = 0; i < nodeCount; i++) {
                int[] coordinateInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                coordinates[i] = new Coordinate(coordinateInfo[0], coordinateInfo[1]);
            }
            System.out.println(solution(nodeCount, coordinates) ? "happy" : "sad");
        }
    }

    private static boolean solution(int nodeCount, Coordinate[] coordinates) {
        List<Integer>[] edges = new List[nodeCount];
        for (int i = 0; i < nodeCount; i++) edges[i] = new ArrayList<>();

        for (int i = 0; i < coordinates.length; i++) {
            for (int j = i + 1; j < coordinates.length; j++) {
                if (coordinates[i].getManhattanDistance(coordinates[j]) <= LIMIT) {
                    edges[i].add(j);
                    edges[j].add(i);
                }
            }
        }

        return bfs(edges, 0, nodeCount - 1);
    }

    private static boolean bfs(List<Integer>[] edges, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[edges.length];
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            if (current == end) return true;

            for (Integer next : edges[current]) {
                if (visited[next]) continue;
                visited[next] = true;
                queue.add(next);
            }
        }

        return false;
    }

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getManhattanDistance(Coordinate coordinate) {
            return Math.abs(this.x - coordinate.x) + Math.abs(this.y - coordinate.y);
        }
    }
}
