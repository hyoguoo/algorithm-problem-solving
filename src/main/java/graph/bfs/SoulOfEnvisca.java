/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16568
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

public class SoulOfEnvisca {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int peopleCount = info[0];
        int moveA = info[1];
        int moveB = info[2];

        System.out.print(solution(peopleCount, moveA, moveB));
    }

    private static int solution(int peopleCount, int moveA, int moveB) {
        int[] times = IntStream.rangeClosed(0, peopleCount)
                .map(i -> Integer.MAX_VALUE)
                .toArray();
        times[peopleCount] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(peopleCount);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == 0) {
                return times[0];
            }

            int currentTime = times[current];
            int[] moves = {1, moveA + 1, moveB + 1};

            for (int move : moves) {
                int next = current - move;
                if (next < 0) {
                    continue;
                }
                if (times[next] > currentTime + 1) {
                    times[next] = currentTime + 1;
                    queue.add(next);
                }
            }
        }

        return times[0];
    }
}
