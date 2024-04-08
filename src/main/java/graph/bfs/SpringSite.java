/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 18513
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SpringSite {

    static final int[] DIRECTIONS = {-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int houseCount = info[1];
        int[] springSites = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(springSites, houseCount));
    }

    private static long solution(int[] springSites, int houseCount) {
        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        for (int springSite : springSites) {
            queue.add(new Node(springSite, 0));
            visited.add(springSite);
        }

        int visitCount = 0;
        long totalDistance = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int direction : DIRECTIONS) {
                int nextIndex = current.currentIndex + direction;
                if (visited.contains(nextIndex)) {
                    continue;
                }
                visitCount++;
                totalDistance += current.distance + 1;

                if (visitCount == houseCount) {
                    return totalDistance;
                }

                visited.add(nextIndex);
                queue.add(new Node(nextIndex, current.distance + 1));
            }
        }

        return totalDistance;
    }

    static class Node {

        int currentIndex;
        int distance;

        public Node(int currentIndex, int distance) {
            this.currentIndex = currentIndex;
            this.distance = distance;
        }
    }
}
