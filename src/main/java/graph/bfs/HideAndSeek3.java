/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 13549
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

public class HideAndSeek3 {

    final static int MAX = 100000;
    static int[] distance = new int[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int src = info[0];
        int dist = info[1];
        Arrays.fill(distance, MAX + 1);

        System.out.println(solution(src, dist));
    }


    private static int solution(int src, int dist) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        distance[src] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == dist) return distance[current];

            if (current * 2 <= MAX) {
                if (distance[current * 2] > distance[current]) {
                    distance[current * 2] = distance[current];
                    queue.add(current * 2);
                }
            }

            if (current + 1 <= MAX) {
                if (distance[current + 1] > distance[current] + 1) {
                    distance[current + 1] = distance[current] + 1;
                    queue.add(current + 1);
                }
            }

            if (current - 1 >= 0) {
                if (distance[current - 1] > distance[current] + 1) {
                    distance[current - 1] = distance[current] + 1;
                    queue.add(current - 1);
                }
            }
        }

        return -1;
    }
}
