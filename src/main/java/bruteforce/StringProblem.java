/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1120
 * Cheat Level: 0
 * Algorithm: Brute Force / String
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");

        System.out.println(getMinimumDifference(input[0], input[1]));
    }

    private static int getMinimumDifference(String s, String s1) {
        int minCount = Integer.MAX_VALUE;

        for (int i = 0; i <= s1.length() - s.length(); i++) {
            int count = getCount(s, s1, i);
            minCount = Math.min(minCount, count);
        }

        return minCount;
    }

    private static int getCount(String s, String s1, int i) {
        int count = 0;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) != s1.charAt(i + j)) count++;
        }
        return count;
    }
}
