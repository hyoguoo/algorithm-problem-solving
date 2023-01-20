/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16234
 * Cheat Level: 0
 * Algorithm: Graph
 */

package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PopulationMovement {

    final static int[][] DIRECTION = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N;
    static int MIN;
    static int MAX;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        MIN = info[1];
        MAX = info[2];
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(solution());
    }

    private static int solution() {
        int count = 0;
        while (visitAll()) count++;

        return count;
    }

    private static boolean visitAll() {
        boolean[][] isVisit = new boolean[N][N];
        boolean isMove = false;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (isVisit[x][y]) continue;
                isVisit[x][y] = true;
                List<Node> movableList = getMovableList(isVisit, x, y);

                if (movableList.size() > 1) {
                    movePopulation(movableList);
                    isMove = true;
                }
            }
        }

        return isMove;
    }

    private static List<Node> getMovableList(boolean[][] isVisit, int x, int y) {
        List<Node> movableList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        movableList.add(new Node(x, y, map[x][y]));
        queue.add(new Node(x, y, map[x][y]));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int currentX = poll.x;
            int currentY = poll.y;
            for (int[] direction : DIRECTION) {
                int nextX = currentX + direction[0];
                int nextY = currentY + direction[1];
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                if (isVisit[nextX][nextY]) continue;
                int diff = Math.abs(map[currentX][currentY] - map[nextX][nextY]);
                if (diff < MIN || diff > MAX) continue;
                isVisit[nextX][nextY] = true;
                queue.add(new Node(nextX, nextY, map[nextX][nextY]));
                movableList.add(new Node(nextX, nextY, map[nextX][nextY]));
            }
        }
        return movableList;
    }

    private static void movePopulation(List<Node> adjacencyList) {
        int sum = adjacencyList.stream().mapToInt(node -> node.population).sum();
        int avg = sum / adjacencyList.size();
        for (Node node : adjacencyList) {
            map[node.x][node.y] = avg;
        }
    }
}

class Node {
    int x;
    int y;
    int population;

    public Node(int x, int y, int population) {
        this.x = x;
        this.y = y;
        this.population = population;
    }
}
