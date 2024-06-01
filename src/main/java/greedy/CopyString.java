/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2195
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CopyString {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String source = bufferedReader.readLine();
        String target = bufferedReader.readLine();

        System.out.print(solution(source, target));
    }

    private static int solution(String source, String target) {
        int count = 0;
        int index = 0;

        while (index < target.length()) {
            int nextIndex = index;
            for (int i = index; i < target.length(); i++) {
                String subString = target.substring(index, i + 1);
                if (source.contains(subString)) {
                    nextIndex = i;
                }
            }
            index = nextIndex + 1;
            count++;
        }

        return count;
    }
}
