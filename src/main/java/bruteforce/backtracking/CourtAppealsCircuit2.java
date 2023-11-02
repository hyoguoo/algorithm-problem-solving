/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10971
 * Cheat Level: 0
 * Algorithm: Brute Force, Backtracking
 */

package bruteforce.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CourtAppealsCircuit2 {

    static final int NOT_CONNECTED = 0;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] costs = new int[n][n];

        for (int i = 0; i < n; i++) {
            costs[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(solution(costs));
    }

    private static int solution(int[][] costs) {
        boolean[] visited = new boolean[costs.length];

        for (int start = 0; start < costs.length; start++) {
            visited[start] = true;
            dfs(costs, visited, start, start, 0, 0);
            visited[start] = false;
        }

        return min;
    }

    private static void dfs(int[][] costs, boolean[] visited, int start, int current, int count, int cost) {
        if (count == costs.length - 1 && costs[current][start] != NOT_CONNECTED) {
            min = Math.min(min, cost + costs[current][start]);
            return;
        }

        for (int next = 0; next < costs.length; next++) {
            if (!visited[next] && costs[current][next] != NOT_CONNECTED) {
                visited[next] = true;
                dfs(costs, visited, start, next, count + 1, cost + costs[current][next]);
                visited[next] = false;
            }
        }
    }
}
