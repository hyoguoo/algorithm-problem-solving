/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 26008
 * Cheat Level: 5
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HashHacking {

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = info[0];
        int m = info[1];
        int a = info[2];
        int h = Integer.parseInt(bufferedReader.readLine());

        System.out.println(solution(n, m, a, h));
    }

    private static long solution(int n, int m, int a, int h) {
        long answer = 1;

        for (int i = 0; i < n - 1; i++) {
            answer = (answer * m) % MOD;
        }

        return answer;
    }
}
