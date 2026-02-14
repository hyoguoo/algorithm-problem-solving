/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10040
 * Cheat Level: 0
 * Algorithm: Implementation
 */
package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Voting {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int gameCount = info[0];
        int commissionerCount = info[1];

        int[] costs = new int[gameCount];
        for (int i = 0; i < gameCount; i++) {
            costs[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int[] standards = new int[commissionerCount];
        for (int i = 0; i < commissionerCount; i++) {
            standards[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(solution(costs, standards));
    }

    private static int solution(int[] costs, int[] standards) {
        int[] votes = new int[costs.length];

        for (int standard : standards) {
            for (int i = 0; i < costs.length; i++) {
                if (costs[i] <= standard) {
                    votes[i]++;
                    break;
                }
            }
        }

        int maxVotes = -1;
        int winningGameIndex = -1;
        for (int i = 0; i < votes.length; i++) {
            if (votes[i] > maxVotes) {
                maxVotes = votes[i];
                winningGameIndex = i;
            }
        }

        return winningGameIndex + 1;
    }
}
