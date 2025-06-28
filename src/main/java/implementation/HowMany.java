/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 27294
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HowMany {

    private static final int RICE_COUNT_LUNCH = 320;
    private static final int RICE_COUNT_DEFAULT = 280;
    private static final Range LUNCH_TIME = new Range(12, 16);

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int time = Integer.parseInt(input[0]);
        boolean withAlcohol = input[1].equals("1");

        System.out.println(solution(time, withAlcohol));
    }

    private static int solution(int time, boolean withAlcohol) {
        boolean isLunchTime = LUNCH_TIME.contains(time);

        return isLunchTime && !withAlcohol
                ? RICE_COUNT_LUNCH
                : RICE_COUNT_DEFAULT;
    }

    private static class Range {

        private final int start;
        private final int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean contains(int value) {
            return value >= start && value <= end;
        }
    }
}
