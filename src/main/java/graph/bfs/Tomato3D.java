/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 7569
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Tomato3D {

    static int M;
    static int N;
    static int H;
    static int[][][] box;
    static Queue<TomatoCoordinate> tomatoCoordinates = new LinkedList<>();
    static int[] dx = {0, 0, 0, 0, 1, -1};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {1, -1, 0, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] infos = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M = infos[0];
        N = infos[1];
        H = infos[2];
        box = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                int[] tomatoList = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = tomatoList[k];
                    if (box[i][j][k] == 1) tomatoCoordinates.add(new TomatoCoordinate(i, j, k));
                }
            }
        }

        solution();
        System.out.println(getMaxValue(box));
    }

    private static int getMaxValue(int[][][] box) {
        int max = Integer.MIN_VALUE;
        for (int[][] boxes : box) {
            for (int[] tomatoes : boxes) {
                for (int tomato : tomatoes) {
                    if (tomato == 0) return -1;
                    if (max < tomato) max = tomato;
                }
            }
        }
        return max - 1;
    }

    private static void solution() {
        while (!tomatoCoordinates.isEmpty()) {
            TomatoCoordinate tomatoCoordinate = tomatoCoordinates.poll();
            for (int d = 0; d < 6; d++) {
                int nx = tomatoCoordinate.x + dx[d];
                int ny = tomatoCoordinate.y + dy[d];
                int nz = tomatoCoordinate.z + dz[d];
                traversal(tomatoCoordinate, nx, ny, nz);
            }
        }
    }

    private static void traversal(TomatoCoordinate tomatoCoordinate, int nx, int ny, int nz) {
        if (0 <= nx && nx < H && 0 <= ny && ny < N && 0 <= nz && nz < M) {
            if (box[nx][ny][nz] == 0) {
                box[nx][ny][nz] = box[tomatoCoordinate.x][tomatoCoordinate.y][tomatoCoordinate.z] + 1;
                tomatoCoordinates.add(new TomatoCoordinate(nx, ny, nz));
            }
        }
    }
}

class TomatoCoordinate {
    int x;
    int y;
    int z;

    public TomatoCoordinate(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}