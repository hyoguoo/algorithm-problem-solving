/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 26122
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestBarMagnet {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();

        System.out.print(solution(bufferedReader.readLine()));
    }

    private static int solution(String str) {
        int count = 1;
        int previousCount = 0;
        int answer = 0;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                previousCount = count;
                count = 1;
            } else {
                count++;
            }

            answer = Math.max(answer, Math.min(previousCount, count) * 2);
        }

        return answer;
    }
}
