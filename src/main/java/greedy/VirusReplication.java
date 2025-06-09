/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9241
 * Cheat Level: 0
 * Algorithm: Greedy / String
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VirusReplication {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String before = bufferedReader.readLine();
        String after = bufferedReader.readLine();
        
        System.out.print(solution(before, after));
    }

    private static int solution(String before, String after) {
        int prefixLength = 0;
        while (prefixLength < before.length() && prefixLength < after.length()
               && before.charAt(prefixLength) == after.charAt(prefixLength)) {
            prefixLength++;
        }
        int suffixLength = 0;
        while (suffixLength < before.length() - prefixLength && suffixLength < after.length() - prefixLength
               && before.charAt(before.length() - 1 - suffixLength) == after.charAt(after.length() - 1 - suffixLength)) {
            suffixLength++;
        }

        return after.length() - prefixLength - suffixLength;
    }
}
