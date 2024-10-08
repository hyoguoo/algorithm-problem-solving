/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1543
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchDocument {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String src = bufferedReader.readLine();
        String target = bufferedReader.readLine();

        System.out.print(solution(src, target));
    }

    private static int solution(String src, String target) {
        int count = 0;
        int index = 0;

        while (index + target.length() <= src.length()) {
            if (src.startsWith(target, index)) {
                count++;
                index += target.length();
            } else {
                index++;
            }
        }

        return count;
    }
}
