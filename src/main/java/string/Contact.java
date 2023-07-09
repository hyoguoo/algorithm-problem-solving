/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1013
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Contact {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(bufferedReader.readLine());

        for (int count = 0; count < caseCount; count++) {
            System.out.println(solution(bufferedReader.readLine()) ? "YES" : "NO");
        }
    }

    private static boolean solution(String input) {
        return input.matches("(100+1+|01)+");
    }
}
