/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5014
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

public class Startlink {

    static final int NOT_VISITED = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(java.lang.Integer::parseInt).toArray();
        int height = info[0];
        int start = info[1];
        int goal = info[2];
        int up = info[3];
        int down = info[4];

        int answer = solution(height, start, goal, up, down);
        System.out.println(answer == NOT_VISITED ? "use the stairs" : answer);
    }

    private static int solution(int height, int start, int goal, int up, int down) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[height + 1];
        Arrays.fill(visited, NOT_VISITED);
        visited[start] = 0;
        queue.add(start);

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            if (current == goal) return visited[current];

            if (current + up <= height && visited[current + up] == NOT_VISITED) {
                visited[current + up] = visited[current] + 1;
                queue.add(current + up);
            }

            if (current - down > 0 && visited[current - down] == NOT_VISITED) {
                visited[current - down] = visited[current] + 1;
                queue.add(current - down);
            }
        }

        return NOT_VISITED;
    }
}
