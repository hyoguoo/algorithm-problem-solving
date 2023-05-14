/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9466
 * Cheat Level: 2
 * Algorithm: Graph / DFS
 */

package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TermProject {

    private static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        for (int t = 1; t <= testCount; t++) {
            int N = Integer.parseInt(bufferedReader.readLine());
            int[] numbers = getNumbers(bufferedReader, N);

            System.out.println(solution(N, numbers));
        }
    }

    private static int solution(int N, int[] numbers) {
        count = 0;
        boolean[] visited = new boolean[N + 1];
        boolean[] isTeam = new boolean[N + 1];

        for (int start = 1; start <= N; start++) {
            if (visited[start]) continue;
            dfs(numbers, start, visited, isTeam);
        }

        return N - count;
    }

    public static void dfs(int[] numbers, int current, boolean[] visited, boolean[] isTeam) {
        if (visited[current]) return;
        if (isTeam[current]) {
            visited[current] = true;
            count++;
        }
        isTeam[current] = true;
        dfs(numbers, numbers[current], visited, isTeam);
        visited[current] = true;
        isTeam[current] = false;
    }

    private static int[] getNumbers(BufferedReader bufferedReader, int N) throws IOException {
        int[] numbers = new int[N + 1];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int n = 1; n <= N; n++) numbers[n] = Integer.parseInt(stringTokenizer.nextToken());
        return numbers;
    }
}
