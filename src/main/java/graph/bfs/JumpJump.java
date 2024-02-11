/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11060
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

public class JumpJump {

    static final int START = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] maze = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(maze));
    }

    private static int solution(int[] maze) {
        int[] count = new int[maze.length];
        Arrays.fill(count, Integer.MAX_VALUE);
        Queue<Integer> queue = new LinkedList<>();

        count[START] = 0;
        queue.add(START);

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            for (int distance = 1; distance <= maze[current]; distance++) {
                int next = current + distance;
                if (!isInRange(maze, next) ||
                    count[next] <= count[current] + 1) continue;
                count[next] = count[current] + 1;
                queue.add(next);
            }
        }

        return count[maze.length - 1] == Integer.MAX_VALUE
                ? -1
                : count[maze.length - 1];
    }

    private static boolean isInRange(int[] maze, int next) {
        return next < maze.length;
    }
}
