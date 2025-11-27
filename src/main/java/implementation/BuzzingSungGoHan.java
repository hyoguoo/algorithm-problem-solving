/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17388
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BuzzingSungGoHan {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(info[0], info[1], info[2]));
    }

    private static String solution(int sung, int go, int han) {
        int threshold = 100;
        if (sung + go + han < threshold) {
            if (sung < go && sung < han) {
                return "Soongsil";
            } else if (go < sung && go < han) {
                return "Korea";
            } else {
                return "Hanyang";
            }
        }
        return "OK";
    }
}
