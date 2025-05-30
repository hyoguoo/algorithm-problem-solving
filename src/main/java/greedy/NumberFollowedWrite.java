/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1515
 * Cheat Level: 0
 * Algorithm: Greedy / Implementation
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberFollowedWrite {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(solution(bufferedReader.readLine()));
    }

    private static int solution(String s) {
        int result = 0;
        int index = 0;

        while (true) {
            result++;
            String resultStr = String.valueOf(result);
            for (int i = 0; i < resultStr.length(); i++) {
                if (resultStr.charAt(i) == s.charAt(index)) {
                    index++;
                }
                if (index == s.length()) {
                    return result;
                }
            }
        }
    }
}
