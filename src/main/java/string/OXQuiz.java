/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 8958
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OXQuiz {

    static final String O = "O";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < length; i++) {
            String[] str = bufferedReader.readLine().split("");
            System.out.println(getScore(str));
        }
    }

    private static int getScore(String[] str) {
        int score = 0;
        int count = 0;
        for (String s : str) {
            if (s.equals(O)) {
                count++;
                score += count;
            } else {
                count = 0;
            }
        }
        return score;
    }
}
