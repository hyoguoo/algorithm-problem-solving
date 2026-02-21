/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11059
 * Cheat Level: 0
 * Algorithm: Brute Force / Prefix Sum
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KreeString {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(solution(bufferedReader.readLine()));
    }

    private static int solution(String s) {
        int[] prefixSum = calulatePrefixSum(s);

        for (int len = (s.length() / 2) * 2; len >= 2; len -= 2) {
            for (int i = 0; i <= s.length() - len; i++) {
                int mid = i + len / 2;
                int end = i + len;

                int firstHalfSum = prefixSum[mid] - prefixSum[i];
                int secondHalfSum = prefixSum[end] - prefixSum[mid];

                if (firstHalfSum == secondHalfSum) {
                    return len;
                }
            }
        }

        return 0;
    }

    private static int[] calulatePrefixSum(String s) {
        int[] prefixSum = new int[s.length() + 1];

        for (int i = 0; i < s.length(); i++) {
            prefixSum[i + 1] = prefixSum[i] + (s.charAt(i) - '0');
        }

        return prefixSum;
    }
}
