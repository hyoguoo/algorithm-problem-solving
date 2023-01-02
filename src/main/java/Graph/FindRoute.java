/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11403
 * Cheat Level: 0
 * Algorithm: Graph
 */

package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FindRoute {

    static int[][] graph;
    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        graph = new int[length][length];
        result = new int[length][length];
        for (int i = 0; i < length; i++) {
            graph[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        solution();
        printResult();
    }

    private static void solution() {
        for (int x = 0; x < graph.length; x++) {
            for (int y = 0; y < graph.length; y++) {
                if (graph[x][y] == 1) bfs(x, y);
            }
        }
    }

    private static void bfs(int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        result[x][y] = 1;
        queue.add(y);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 0; i < graph.length; i++) {
                if (graph[current][i] == 1 && result[x][i] == 0) {
                    result[x][i] = 1;
                    queue.add(i);
                }
            }
        }
    }

    private static void printResult() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] ints : result) {
            for (int anInt : ints) {
                stringBuilder.append(anInt).append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }
}
