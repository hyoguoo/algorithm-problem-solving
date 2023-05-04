/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10026
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class RedGreenColorWeakness {

    final static String RED = "R";
    final static String GREEN = "G";
    final static String VISIT = "0";
    final static int[][] DIRECTION = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        String[][] normalGraph = new String[length][length];

        for (int i = 0; i < length; i++) {
            String[] input = bufferedReader.readLine().split("");
            System.arraycopy(input, 0, normalGraph[i], 0, length);
        }

        String[][] colorWeaknessGraph = getColorWeaknessGraph(length, normalGraph);
        System.out.println(getCount(normalGraph) + " " + getCount(colorWeaknessGraph));
    }

    private static int getCount(String[][] graph) {
        int count = 0;

        while (true) {
            RGBPoint notVisited = getNotVisited(graph);
            if (notVisited == null) break;
            int x = notVisited.x;
            int y = notVisited.y;
            count++;
            bfs(x, y, graph);
        }

        return count;
    }

    private static RGBPoint getNotVisited(String[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (!graph[i][j].equals(VISIT)) return new RGBPoint(i, j);
            }
        }
        return null;
    }

    private static void bfs(int x, int y, String[][] graph) {
        Queue<RGBPoint> queue = new LinkedList<>();
        queue.add(new RGBPoint(x, y));
        String referenceColor = graph[x][y];
        graph[x][y] = VISIT;

        while (!queue.isEmpty()) {
            RGBPoint poll = queue.poll();

            for (int[] direction : DIRECTION) {
                int nextX = poll.x + direction[0];
                int nextY = poll.y + direction[1];

                if (isInGraph(nextX, nextY, graph) && graph[nextX][nextY].equals(referenceColor)) {
                    queue.add(new RGBPoint(nextX, nextY));
                    graph[nextX][nextY] = VISIT;
                }
            }
        }
    }

    private static boolean isInGraph(int nextX, int nextY, String[][] graph) {
        return 0 <= nextX && nextX < graph.length && 0 <= nextY && nextY < graph.length;
    }

    private static String[][] getColorWeaknessGraph(int length, String[][] graph) {
        String[][] colorWeaknessGraph = new String[length][length];
        for (int i = 0; i < length; i++) {
            System.arraycopy(graph[i], 0, colorWeaknessGraph[i], 0, length);
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (colorWeaknessGraph[i][j].equals(GREEN)) colorWeaknessGraph[i][j] = RED;
            }
        }

        return colorWeaknessGraph;
    }
}

class RGBPoint {
    int x;
    int y;

    public RGBPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
