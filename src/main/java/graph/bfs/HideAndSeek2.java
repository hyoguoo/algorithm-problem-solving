/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 12851
 * Cheat Level: 0
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HideAndSeek2 {

    final static List<Integer> list = new ArrayList<>();
    final static int MAX = 100000;
    static int START;
    static int TARGET;
    static int[] distance = new int[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        START = info[0];
        TARGET = info[1];
        Arrays.fill(distance, MAX + 1);
        bfs();
        System.out.println(list.get(0));
        System.out.println(list.size());
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(START);
        distance[START] = 0;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            if (current == TARGET) {
                list.add(distance[current]);
                continue;
            }

            if (current * 2 <= MAX) {
                if (distance[current * 2] >= distance[current] + 1) {
                    distance[current * 2] = distance[current] + 1;
                    queue.add(current * 2);
                }
            }

            if (current + 1 <= MAX) {
                if (distance[current + 1] >= distance[current] + 1) {
                    distance[current + 1] = distance[current] + 1;
                    queue.add(current + 1);
                }
            }
            if (current - 1 >= 0) {
                if (distance[current - 1] >= distance[current] + 1) {
                    distance[current - 1] = distance[current] + 1;
                    queue.add(current - 1);
                }
            }
        }
    }
}
