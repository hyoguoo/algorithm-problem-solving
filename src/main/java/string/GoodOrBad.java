/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4447
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoodOrBad {

    private static final char GOOD = 'g';
    private static final char BAD = 'b';

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            stringBuilder.append(solution(bufferedReader.readLine())).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static String solution(String name) {
        int goodCount = 0;
        int badCount = 0;

        for (char c : name.toLowerCase().toCharArray()) {
            if (c == GOOD || c == BAD) {
                if (c == GOOD) {
                    goodCount++;
                } else {
                    badCount++;
                }
            }
        }

        switch (Integer.compare(goodCount, badCount)) {
            case 1:
                return name + " is GOOD";
            case -1:
                return name + " is A BADDY";
            default:
                return name + " is NEUTRAL";
        }
    }
}
