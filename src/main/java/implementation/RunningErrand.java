/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5544
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RunningErrand {

    private static final int INPUT_LINE_COUNT = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] seconds = new int[INPUT_LINE_COUNT];

        for (int i = 0; i < INPUT_LINE_COUNT; i++) {
            seconds[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(solution(seconds));
    }

    private static String solution(int[] seconds) {
        Time time = new Time();

        Arrays.stream(seconds).forEach(time::addSeconds);

        return time.toString();
    }

    static class Time {

        private int seconds;

        public Time() {
            this.seconds = 0;
        }

        public void addSeconds(int seconds) {
            this.seconds += seconds;
        }

        @Override
        public String toString() {
            return seconds / 60 + "\n" + seconds % 60;
        }
    }
}
