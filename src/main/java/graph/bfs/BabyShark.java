/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16236
 * Cheat Level: 3
 * Algorithm: Graph / Priority Queue / Implementation / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BabyShark {

    final static int[][] DIRECTION = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    static int sharkSize = 2;
    static int sharkEat = 0;
    static int sharkX;
    static int sharkY;
    static int time = 0;
    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        map = new int[N][N];

        for (int x = 0; x < N; x++) {
            String[] input = bufferedReader.readLine().split(" ");
            for (int y = 0; y < N; y++) {
                int value = Integer.parseInt(input[y]);
                if (value == 9) {
                    sharkX = x;
                    sharkY = y;
                } else {
                    map[x][y] = value;
                }
            }
        }
        bfs();
        System.out.println(time);
    }

    private static void bfs() {
        while (true) {
            PriorityQueue<MapCoordinate> eatableFish = eatNextFish();
            if (eatableFish.isEmpty()) return;
            eatFish(eatableFish.peek());
        }
    }

    private static PriorityQueue<MapCoordinate> eatNextFish() {
        Queue<MapCoordinate> queue = new LinkedList<>();
        PriorityQueue<MapCoordinate> enableFish = new PriorityQueue<>(customComparator());
        queue.add(new MapCoordinate(sharkX, sharkY, 0));
        boolean[][] visited = new boolean[N][N];

        while (!queue.isEmpty()) {
            MapCoordinate currentPosition = queue.poll();
            int currentX = currentPosition.x;
            int currentY = currentPosition.y;
            int currentDistance = currentPosition.distance;
            if (visited[currentX][currentY]) continue;
            visited[currentX][currentY] = true;

            for (int[] direction : DIRECTION) {
                int nextX = currentX + direction[0];
                int nextY = currentY + direction[1];

                if (isAvailable(nextX, nextY)) continue;
                if (0 < map[nextX][nextY] && map[nextX][nextY] < sharkSize) {
                    enableFish.add(new MapCoordinate(nextX, nextY, currentDistance + 1));
                }
                queue.add(new MapCoordinate(nextX, nextY, currentDistance + 1));
            }
        }
        return enableFish;
    }

    private static Comparator<MapCoordinate> customComparator() {
        return (o1, o2) -> {
            if (o1.distance != o2.distance) return o1.distance - o2.distance;
            if (o1.x != o2.x) return o1.x - o2.x;
            return o1.y - o2.y;
        };
    }

    private static boolean isAvailable(int nextX, int nextY) {
        if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) return true;
        if (map[nextX][nextY] > sharkSize) return true;
        return false;
    }

    private static void eatFish(MapCoordinate eatFish) {
        int nextX = eatFish.x;
        int nextY = eatFish.y;
        int distance = eatFish.distance;
        sharkEat++;
        if (sharkEat == sharkSize) {
            sharkSize++;
            sharkEat = 0;
        }
        map[nextX][nextY] = 0;
        time += distance;
        sharkX = nextX;
        sharkY = nextY;
    }
}

class MapCoordinate {

    int x;
    int y;
    int distance;

    public MapCoordinate(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}
