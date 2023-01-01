/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14500
 * Cheat Level: 1
 * Algorithm: Brute Force / Backtracking
 */

package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Tetromino {

    static int M;
    static int N;
    static int[][] scores;
    static boolean[][] visit;
    static int maxScore = Integer.MIN_VALUE;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M = info[0];
        N = info[1];
        scores = new int[M][N];
        visit = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            scores[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int x = 0; x < M; x++) {
            for (int y = 0; y < N; y++) {
                getTShapeMaxScore(x, y);
                getBfsShapeMaxScore(x, y, 0, 0);
            }
        }

        System.out.println(maxScore);
    }

    private static void getBfsShapeMaxScore(int x, int y, int score, int count) {
        if (count == 4) {
            maxScore = Math.max(maxScore, score);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
            if (visit[nx][ny]) continue;
            visit[nx][ny] = true;
            getBfsShapeMaxScore(nx, ny, score + scores[nx][ny], count + 1);
            visit[nx][ny] = false;
        }
    }

    private static void getTShapeMaxScore(int x, int y) {
        int score = scores[x][y];
        int count = 1;
        for (int d = 0; d < 4; d++) {
            int nextX = x + dx[d];
            int nextY = y + dy[d];
            if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) continue;
            score += scores[nextX][nextY];
            count++;
        }

        if (count == 5) {
            score -= Math.min(Math.min(scores[x + 1][y], scores[x - 1][y]), Math.min(scores[x][y + 1], scores[x][y - 1]));
        }
        maxScore = Math.max(maxScore, score);
    }
}
