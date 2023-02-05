/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 18405
 * Cheat Level: 0
 * Algorithm: Graph
 */

package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class CompetitiveContagion {

    final static int[][] DIRECTION = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    final static Queue<Node> nodeList = new PriorityQueue<>();
    static int N;
    static int LIMIT;
    static int[][] map;
    static int TARGET_X;
    static int TARGET_Y;
    static int TARGET_SECOND;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        LIMIT = info[1];
        map = new int[N][N];
        setMap(bufferedReader);
        setTarget(bufferedReader);

        bfs();
        System.out.println(map[TARGET_X][TARGET_Y]);
    }

    private static void bfs() {
        while (!nodeList.isEmpty()) {
            Node currentNode = nodeList.poll();
            int currentX = currentNode.x;
            int currentY = currentNode.y;
            int currentSecond = currentNode.second;
            for (int[] direction : DIRECTION) {
                int nextX = currentX + direction[0];
                int nextY = currentY + direction[1];
                int nextSecond = currentSecond + 1;
                if (isAvailable(nextX, nextY, nextSecond)) continue;
                map[nextX][nextY] = map[currentX][currentY];
                if (nextX == TARGET_X && nextY == TARGET_Y) return;
                nodeList.add(new Node(nextX, nextY, nextSecond, map[nextX][nextY]));
            }
        }
    }

    private static boolean isAvailable(int nextX, int nextY, int nextSecond) {
        if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) return false;
        if (map[nextX][nextY] != 0) return false;
        if (nextSecond > TARGET_SECOND) return false;
        return true;
    }

    private static void setTarget(BufferedReader bufferedReader) throws IOException {
        int[] target = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        TARGET_SECOND = target[0];
        TARGET_X = target[1] - 1;
        TARGET_Y = target[2] - 1;
    }

    private static void setMap(BufferedReader bufferedReader) throws IOException {
        for (int i = 0; i < N; i++) {
            int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < N; j++) {
                int priority = numbers[j];
                map[i][j] = priority;
                if (priority != 0) nodeList.add(new Node(i, j, 0, priority));
            }
        }
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int second;
        int priority;

        public Node(int x, int y, int second, int priority) {
            this.x = x;
            this.y = y;
            this.second = second;
            this.priority = priority;
        }

        @Override
        public int compareTo(Node o) {
            if (this.second == o.second) return this.priority - o.priority;
            return this.second - o.second;
        }
    }
}
