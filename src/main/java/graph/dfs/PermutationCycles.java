/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10451
 * Cheat Level: 0
 * Algorithm: Graph / DFS
 */

package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PermutationCycles {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            bufferedReader.readLine();
            int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .map(i -> i - 1)
                    .toArray();
            stringBuilder.append(solution(numbers)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int[] numbers) {
        boolean[] visited = new boolean[numbers.length];
        int count = 0;

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                dfs(numbers, visited, i);
                count++;
            }
        }

        return count;
    }

    private static void dfs(int[] numbers, boolean[] visited, int vertex) {
        visited[vertex] = true;

        if (!visited[numbers[vertex]]) {
            dfs(numbers, visited, numbers[vertex]);
        }
    }
}
