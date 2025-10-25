/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11558
 * Cheat Level: 0
 * Algorithm: Graph / Implementation
 */

package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheGameOfDeath {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(reader.readLine());
        StringBuilder answerBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            int playerCount = Integer.parseInt(reader.readLine());
            int[] playerChoices = new int[playerCount + 1];

            for (int i = 1; i <= playerCount; i++) {
                playerChoices[i] = Integer.parseInt(reader.readLine());
            }

            answerBuilder
                    .append(solution(playerChoices, playerCount, playerCount))
                    .append(System.lineSeparator());
        }

        System.out.print(answerBuilder.toString().trim());
    }

    private static int solution(int[] playerChoices, int playerCount, int targetPlayer) {
        boolean[] visited = new boolean[playerCount + 1];
        int currentPlayer = 1;
        int count = 0;

        while (true) {
            if (visited[currentPlayer]) {
                return 0;
            }
            visited[currentPlayer] = true;

            int nextPlayer = playerChoices[currentPlayer];
            count++;

            if (nextPlayer == targetPlayer) {
                return count;
            }

            currentPlayer = nextPlayer;
        }
    }
}
