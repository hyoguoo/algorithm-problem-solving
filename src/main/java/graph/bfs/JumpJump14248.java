/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14248
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
import java.util.stream.IntStream;

public class JumpJump14248 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] jumpDistances = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int startIndex = Integer.parseInt(bufferedReader.readLine()) - 1;

        System.out.print(solution(jumpDistances, startIndex));
    }

    private static int solution(int[] jumpDistances, int startIndex) {
        boolean[] visited = new boolean[jumpDistances.length];
        Queue<Integer> queue = new LinkedList<>();

        visited[startIndex] = true;
        queue.add(startIndex);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int jumpDistance = jumpDistances[current];

            extracted(queue, visited, jumpDistances, current - jumpDistance);
            extracted(queue, visited, jumpDistances, current + jumpDistance);
        }


        return IntStream.range(0, visited.length)
                .map(i -> visited[i] ? 1 : 0)
                .sum();
    }

    private static void extracted(Queue<Integer> queue, boolean[] visited, int[] jumpDistances, int current) {
        if (isInRange(jumpDistances, current) && !visited[current]) {
            visited[current] = true;
            queue.add(current);
        }
    }

    private static boolean isInRange(int[] jumpDistances, int next) {
        return 0 <= next && next < jumpDistances.length;
    }
}
