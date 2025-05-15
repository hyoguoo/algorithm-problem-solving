/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15881
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PenPineappleApplePen {

    private static final String PPAP = "pPAp";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        String line = bufferedReader.readLine();
        System.out.print(solution(line));
    }

    private static int solution(String line) {
        int count = 0;
        int i = 0;
        while ((i = line.indexOf(PPAP, i)) != -1) {
            count++;
            i += PPAP.length();
        }
        return count;
    }
}
