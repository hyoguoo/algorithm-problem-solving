/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1032
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandPrompt {

    static final char QUESTION_MARK = '?';

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        char[] charArray = bufferedReader.readLine().toCharArray();

        for (int i = 0; i < n - 1; i++) {
            char[] compareArray = bufferedReader.readLine().toCharArray();

            for (int j = 0; j < charArray.length; j++) {
                if (charArray[j] != compareArray[j]) charArray[j] = QUESTION_MARK;
            }
        }

        System.out.println(new String(charArray));
    }
}
