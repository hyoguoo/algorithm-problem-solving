/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 13913
 * Cheat Level: 3
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class HideAndSeek4 {

    final static int MAX = 100000;
    static int[] distance = new int[MAX * 2 + 1];
    static int[] previous = new int[MAX * 2 + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int src = info[0];
        int dist = info[1];
        Arrays.fill(distance, MAX * 2 + 1);
        Arrays.fill(previous, -1);

        solution(src, dist);
    }


    private static void solution(int src, int dist) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        distance[src] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == dist) {
                printResult(current);
                return;
            }

            if (current * 2 <= MAX * 2) {
                if (distance[current * 2] > distance[current]) {
                    distance[current * 2] = distance[current] + 1;
                    previous[current * 2] = current;
                    queue.add(current * 2);
                }
            }

            if (current + 1 <= MAX) {
                if (distance[current + 1] > distance[current] + 1) {
                    distance[current + 1] = distance[current] + 1;
                    previous[current + 1] = current;
                    queue.add(current + 1);
                }
            }

            if (current - 1 >= 0) {
                if (distance[current - 1] > distance[current] + 1) {
                    distance[current - 1] = distance[current] + 1;
                    previous[current - 1] = current;
                    queue.add(current - 1);
                }
            }
        }
    }

    private static void printResult(int current) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(distance[current]).append("\n");

        LinkedList<Integer> path = new LinkedList<>();
        while (current != -1) {
            path.addFirst(current);
            current = previous[current];
        }

        for (Integer integer : path) {
            stringBuilder.append(integer).append(" ");
        }

        System.out.println(stringBuilder);
    }
}
