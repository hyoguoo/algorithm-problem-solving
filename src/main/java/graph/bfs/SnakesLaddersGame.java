/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16928
 * Cheat Level: 2
 * Algorithm: Graph / BFS
 */

package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SnakesLaddersGame {

    final static int TARGET = 100;
    final static int DICE = 6;
    final static int[] board = new int[TARGET + 1];
    final static Map<Integer, Integer> snakesAndLadders = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int ladderLength = info[0];
        int snakeLength = info[1];
        for (int i = 0; i < ladderLength + snakeLength; i++) {
            int[] ladderOrSnake = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            snakesAndLadders.put(ladderOrSnake[0], ladderOrSnake[1]);
        }
        bfs();
        System.out.println(board[TARGET]);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        board[1] = 0;
        queue.add(1);

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            for (int i = current + 1; i <= current + DICE; i++) {
                if (i > TARGET) {
                    break;
                }
                if (snakesAndLadders.containsKey(i)) {
                    int next = snakesAndLadders.get(i);
                    if (board[next] == 0) {
                        board[next] = board[current] + 1;
                        queue.add(next);
                    }
                    continue;
                }
                if (board[i] == 0) {
                    board[i] = board[current] + 1;
                    queue.add(i);
                }
            }
        }
    }
}
