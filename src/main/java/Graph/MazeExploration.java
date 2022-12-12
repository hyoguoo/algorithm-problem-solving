/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2178
 */

package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MazeExploration {

    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};
    static int M;
    static int N;

    static int[][] maze;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] infos = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M = infos[0];
        N = infos[1];

        maze = new int[M][N];
        for (int i = 0; i < M; i++) {
            String[] line = bufferedReader.readLine().split("");
            for (int j = 0; j < N; j++) maze[i][j] = Integer.parseInt(line[j]);
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        List<Point> pointList = new ArrayList<>();

        pointList.add(new Point(0, 0));
        while (!pointList.isEmpty()) {
            Point currentPoint = pointList.remove(0);
            int x = currentPoint.x;
            int y = currentPoint.y;
            if (x == M - 1 && y == N - 1) return maze[M - 1][N - 1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < M && 0 <= ny && ny < N && maze[nx][ny] == 1) {
                    pointList.add(new Point(nx, ny));
                    maze[nx][ny] = maze[x][y] + 1;
                }
            }
            maze[x][y] = 0;
        }

        return -1;
    }
}


class Point {

    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}