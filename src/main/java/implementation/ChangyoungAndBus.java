/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 22113
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ChangyoungAndBus {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] first = bufferedReader.readLine().trim().split("\\s+");
        int n = Integer.parseInt(first[0]);

        int[] route = Arrays.stream(bufferedReader.readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] transfer = new int[n][n];
        for (int i = 0; i < n; i++) {
            transfer[i] = Arrays.stream(bufferedReader.readLine().trim().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        System.out.print(solution(route, transfer));
    }


    private static int solution(int[] route, int[][] transfer) {
        int sum = 0;
        for (int i = 0; i < route.length - 1; i++) {
            int from = route[i] - 1;
            int to = route[i + 1] - 1;
            sum += transfer[from][to];
        }
        return sum;
    }
}
