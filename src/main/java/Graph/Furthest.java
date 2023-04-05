/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 22865
 * Cheat Level: 2
 * Algorithm: Dijkstra / Graph
 */

/*
기본 다익스트라 문제이지만, 모든 정점에 대해 실행할 필요 없이,
A/B/C에 대해 각각 다익스트라를 실행하고, 그 결과를 비교하면 된다.
 */

package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Furthest {

    final static int INF = Integer.MAX_VALUE;
    static int VERTEX_COUNT, A, B, C;
    static List<Vertex>[] ADJACENCY_LIST;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solution());
    }

    private static int solution() {
        int[] distancesFromA = getDistancesFromIndex(A);
        int[] distancesFromB = getDistancesFromIndex(B);
        int[] distancesFromC = getDistancesFromIndex(C);

        int maximumDistance = Integer.MIN_VALUE;
        int maximumDistanceIndex = 0;
        for (int i = 1; i <= VERTEX_COUNT; i++) {
            int minimumDistanceToFriends = Math.min(Math.min(distancesFromA[i], distancesFromB[i]), distancesFromC[i]);
            if (minimumDistanceToFriends > maximumDistance) {
                maximumDistance = minimumDistanceToFriends;
                maximumDistanceIndex = i;
            }
        }

        return maximumDistanceIndex;
    }

    private static int[] getDistancesFromIndex(int vertexIndex) {
        int[] distances = new int[VERTEX_COUNT + 1];
        Arrays.fill(distances, INF);
        distances[vertexIndex] = 0;

        boolean[] visited = new boolean[VERTEX_COUNT + 1];

        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Vertex(vertexIndex, 0));

        while (!priorityQueue.isEmpty()) {
            Vertex current = priorityQueue.poll();

            int currentIndex = current.to;
            int currentDistance = current.distance;

            if (visited[currentIndex]) continue;
            visited[currentIndex] = true;

            for (Vertex next : ADJACENCY_LIST[currentIndex]) {
                int nextIndex = next.to;
                int currentToNextDistance = next.distance;
                int newDistance = currentDistance + currentToNextDistance;
                if (distances[nextIndex] > newDistance) {
                    distances[nextIndex] = newDistance;
                    priorityQueue.add(new Vertex(nextIndex, newDistance));
                }
            }
        }

        return distances;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        VERTEX_COUNT = Integer.parseInt(bufferedReader.readLine());
        int[] friends = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        A = friends[0];
        B = friends[1];
        C = friends[2];

        ADJACENCY_LIST = new ArrayList[VERTEX_COUNT + 1];
        for (int i = 1; i <= VERTEX_COUNT; i++) ADJACENCY_LIST[i] = new ArrayList<>();

        int vertexCount = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < vertexCount; i++) {
            int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int from = edgeInfo[0];
            int to = edgeInfo[1];
            int distance = edgeInfo[2];
            ADJACENCY_LIST[from].add(new Vertex(to, distance));
            ADJACENCY_LIST[to].add(new Vertex(from, distance));
        }
    }

    static class Vertex implements Comparable<Vertex> {
        int to;
        int distance;

        public Vertex(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.distance - o.distance;
        }
    }
}
