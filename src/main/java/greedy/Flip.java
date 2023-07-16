/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1439
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Flip {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(bufferedReader.readLine()));
    }

    private static int solution(String s) {
        int changed = 0;
        char prev = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            if (prev != s.charAt(i)) {
                changed++;
                prev = s.charAt(i);
            }
        }

        return changed / 2;
    }
}
