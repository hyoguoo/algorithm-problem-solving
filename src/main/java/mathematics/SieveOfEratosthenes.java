/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2906
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SieveOfEratosthenes {

    static final int MIN = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(info[0], info[1]));
    }

    private static int solution(int n, int k) {
        int count = 0;
        boolean[] isPrime = new boolean[n + 1];

        for (int i = MIN; i <= n; i++) {
            int multiple = 1;
            while (i * multiple <= n) {
                int number = i * multiple++;
                if (isPrime[number]) continue;
                isPrime[number] = true;
                count++;
                if (count == k) return number;
            }
        }

        return -1;
    }
}
