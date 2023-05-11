/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1987
 * Cheat Level: 0
 * Algorithm: Graph / DFS
 */

package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Alphabet {

    final static int START_R = 0;
    final static int START_C = 0;
    final static int ALPHABET_SIZE = 26;
    final static boolean[] alphabet = new boolean[ALPHABET_SIZE];
    final static int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static char[][] graph;
    static int R, C;
    static int maxDistance = 1;

    public static void main(String[] args) throws IOException {
        init();
        dfs(START_R, START_C, 1);
        System.out.println(maxDistance);
    }

    private static void dfs(int currentR, int currentC, int distance) {
        maxDistance = Math.max(maxDistance, distance);

        for (int[] direction : DIRECTIONS) {
            int nextR = currentR + direction[0];
            int nextC = currentC + direction[1];
            if (!isValid(nextR, nextC)) continue;
            alphabet[getArrayIndex(graph[nextR][nextC])] = true;
            dfs(nextR, nextC, distance + 1);
            alphabet[getArrayIndex(graph[nextR][nextC])] = false;
        }
    }

    private static boolean isValid(int r, int c) {
        return isInBound(r, c) && !isVisited(r, c);
    }

    private static boolean isInBound(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }

    private static boolean isVisited(int r, int c) {
        return alphabet[getArrayIndex(graph[r][c])];
    }

    private static int getArrayIndex(char c) {
        return c - 'A';
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        R = info[0];
        C = info[1];
        graph = new char[R][C];
        for (int i = 0; i < R; i++) graph[i] = bufferedReader.readLine().toCharArray();
        alphabet[getArrayIndex(graph[START_R][START_C])] = true;
    }
}
