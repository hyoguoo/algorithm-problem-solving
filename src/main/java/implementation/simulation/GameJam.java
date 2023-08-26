/*
 * goormlevel
 * https://level.goorm.io
 * Goormthon Challenge: 10일차
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class GameJam {

    final static HashMap<String, int[]> directions = new HashMap<>() {
        {
            put("U", new int[]{-1, 0});
            put("D", new int[]{1, 0});
            put("L", new int[]{0, -1});
            put("R", new int[]{0, 1});
        }
    };
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        int[] goormInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] playerInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String[][] board = new String[N][N];
        for (int n = 0; n < N; n++) {
            board[n] = bufferedReader.readLine().split(" ");
        }

        solution(board, goormInfo, playerInfo);
    }

    private static void solution(String[][] board, int[] goormInfo, int[] playerInfo) {
        int goormScore = move(goormInfo[0] - 1, goormInfo[1] - 1, board);
        int playerScore = move(playerInfo[0] - 1, playerInfo[1] - 1, board);

        if (goormScore > playerScore) System.out.println("goorm " + goormScore);
        else if (goormScore < playerScore) System.out.println("player " + playerScore);
    }


    public static int move(int n, int m, String[][] board) {
        boolean[][] visited = new boolean[N][N];
        int score = 1;
        visited[n][m] = true;
        boolean enable = true;

        while (enable) {
            String command = board[n][m];
            int distance = Integer.parseInt(command.substring(0, command.length() - 1));
            String direction = command.substring(command.length() - 1);

            for (int i = 0; i < distance; i++) {
                n = fixBoundary(n + directions.get(direction)[0]);
                m = fixBoundary(m + directions.get(direction)[1]);

                if (visited[n][m]) {
                    enable = false;
                    break;
                }
                visited[n][m] = true;
                score++;
            }
        }

        return score;
    }

    public static int fixBoundary(int a) {
        if (a == -1) return N - 1;
        if (a == N) return 0;
        return a;
    }
}
