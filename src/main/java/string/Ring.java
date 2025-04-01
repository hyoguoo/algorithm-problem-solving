/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5555
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ring {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String target = bufferedReader.readLine();
        int ringCount = Integer.parseInt(bufferedReader.readLine());

        String[] ringStrings = new String[ringCount];

        for (int i = 0; i < ringCount; i++) {
            ringStrings[i] = bufferedReader.readLine();
        }

        System.out.print(solution(target, ringStrings));
    }

    private static long solution(String target, String[] ringStrings) {
        return Arrays.stream(ringStrings)
                .filter(str -> isContain(target, str))
                .count();
    }

    private static boolean isContain(String target, String ringString) {
        String doubleRingString = ringString + ringString;
        return doubleRingString.contains(target);
    }
}
