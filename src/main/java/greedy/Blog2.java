/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 20365
 * Cheat Level: 0
 * Algorithm: Greedy / String
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Blog2 {

    private static final char RED = 'R';
    private static final char BLUE = 'B';

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();

        System.out.print(solution(bufferedReader.readLine()));
    }

    private static int solution(String colors) {
        int redGroupCount = 0;
        int blueGroupCount = 0;

        int index = 0;
        while (index < colors.length()) {
            char color = colors.charAt(index);

            while (index < colors.length() && colors.charAt(index) == color) {
                index++;
            }

            if (color == RED) {
                redGroupCount++;
            } else if (color == BLUE) {
                blueGroupCount++;
            } else {
                throw new IllegalArgumentException();
            }
        }

        return Math.min(redGroupCount, blueGroupCount) + 1;
    }
}
