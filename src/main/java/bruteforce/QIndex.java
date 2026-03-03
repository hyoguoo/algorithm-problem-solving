/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 13333
 * Cheat Level: 0
 * Algorithm: Brute Force / Sort
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QIndex {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] citationCounts = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(citationCounts));
    }

    private static int solution(int[] citationCounts) {
        Arrays.sort(citationCounts);
        int n = citationCounts.length;

        for (int k = n; k >= 0; k--) {
            if (k == 0) {
                return 0;
            }
            if (citationCounts[n - k] >= k) {
                if (n - k == 0 || citationCounts[n - k - 1] <= k) {
                    return k;
                }
            }
        }

        return 0;
    }
}
