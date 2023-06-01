/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9328
 * Cheat Level: 0
 * Algorithm: Graph / BFS / Implementation
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Keys {

    final static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    final static int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    final static char EMPTY = '.';
    final static char WALL = '*';
    final static char TARGET = '$';

    public static void main(String[] args) throws IOException {
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        for (int count = 0; count < testCaseCount; count++) {
            List<Coordinate> entryPointList = new ArrayList<>();
            char[][] graph = initGraph(entryPointList);
            boolean[] hasKeys = initHasKeys();
            int answer = solution(graph, hasKeys, entryPointList);
            System.out.println(answer);
        }
    }

    private static int solution(char[][] graph, boolean[] hasKeys, List<Coordinate> entryPointList) {
        Queue<Coordinate> queue = new LinkedList<>(entryPointList);
        int H = graph.length;
        int W = graph[0].length;
        boolean[][] visited = new boolean[H][W];
        int answer = 0;


        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            char currentValue = graph[current.h][current.w];

            if (currentValue == TARGET) {
                answer++;
                graph[current.h][current.w] = EMPTY;
            }

            if (isUppercase(currentValue)) { // is door
                if (hasKeys[alphabetToNumber(currentValue)]) graph[current.h][current.w] = EMPTY;
                else continue;
            }

            if (isLowercase(currentValue) && !hasKeys[alphabetToNumber(currentValue)]) { // is key
                hasKeys[alphabetToNumber(currentValue)] = true;
                queue.clear();
                queue.addAll(entryPointList);
                visited = new boolean[H][W];
            }

            if (visited[current.h][current.w]) continue;
            visited[current.h][current.w] = true;

            for (int[] direction : DIRECTIONS) {
                int nextH = current.h + direction[0];
                int nextW = current.w + direction[1];

                if (isInBorder(nextH, nextW, H, W) && graph[nextH][nextW] != WALL) {
                    queue.add(new Coordinate(nextH, nextW));
                }
            }
        }

        return answer;
    }

    private static boolean isInBorder(int h, int w, int H, int W) {
        return 0 <= h && h < H && 0 <= w && w < W;
    }


    private static boolean isLowercase(char c) {
        return 'a' <= c && c <= 'z';
    }

    private static boolean isUppercase(char c) {
        return 'A' <= c && c <= 'Z';
    }

    private static int alphabetToNumber(char c) {
        if (isLowercase(c)) return c - 'a';
        else return c - 'A';
    }

    private static char[][] initGraph(List<Coordinate> entryPointList) throws IOException {
        int[] graphInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int H = graphInfo[0];
        int W = graphInfo[1];
        char[][] graph = new char[H][W];
        for (int h = 0; h < H; h++) {
            char[] input = bufferedReader.readLine().toCharArray();
            for (int w = 0; w < W; w++) {
                graph[h][w] = input[w];
                if (input[w] != WALL && isBorder(h, w, H, W)) entryPointList.add(new Coordinate(h, w));
            }
        }
        return graph;
    }

    private static boolean isBorder(int h, int w, int H, int W) {
        return h == 0 || w == 0 || h == H - 1 || w == W - 1;
    }

    private static boolean[] initHasKeys() throws IOException {
        char[] keys = bufferedReader.readLine().toCharArray();
        boolean[] hasKeys = new boolean[26];
        for (char key : keys) {
            if (key == '0') break;
            hasKeys[alphabetToNumber(key)] = true;
        }
        return hasKeys;
    }

    static class Coordinate {
        int h;
        int w;

        public Coordinate(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }
}
