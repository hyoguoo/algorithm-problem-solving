/*
 * PROGRAMMERS SCHOOL
 * https://school.programmers.co.kr
 * Problem Number: 1844
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortestDistance {

    final static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    final static int START_N = 0;
    final static int START_M = 0;
    final static int VISITED_OR_WALL = 0;
    static int END_N;
    static int END_M;

    public static void main(String[] args) {
        GameMapShortestDistance gameMapShortestDistance = new GameMapShortestDistance();
        System.out.println(gameMapShortestDistance.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
    }

    public int solution(int[][] maps) {
        END_N = maps.length - 1;
        END_M = maps[0].length - 1;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(START_N, START_M, 1));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.n == END_N && current.m == END_M) return current.count;
            if (maps[current.n][current.m] == VISITED_OR_WALL) continue;
            maps[current.n][current.m] = VISITED_OR_WALL;

            for (int[] direction : DIRECTIONS) {
                int nextN = current.n + direction[0];
                int nextM = current.m + direction[1];

                if (isNotInMap(nextN, nextM) || maps[nextN][nextM] == VISITED_OR_WALL) continue;
                queue.add(new Node(nextN, nextM, current.count + 1));
            }
        }

        return -1;
    }

    private boolean isNotInMap(int n, int m) {
        return n < 0 || n > END_N || m < 0 || m > END_M;
    }

    static class Node {
        int n;
        int m;
        int count;

        public Node(int n, int m, int count) {
            this.n = n;
            this.m = m;
            this.count = count;
        }
    }
}
