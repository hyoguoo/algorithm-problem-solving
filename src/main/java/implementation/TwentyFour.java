/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1408
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwentyFour {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Time currentTime = Time.parse(bufferedReader.readLine());
        Time targetTime = Time.parse(bufferedReader.readLine());

        System.out.print(solution(targetTime, currentTime));
    }

    private static Time solution(Time targetTime, Time currentTime) {
        return targetTime.subtract(currentTime);
    }

    static class Time {

        private final int hour;
        private final int minute;
        private final int second;

        public Time(int hour, int minute, int second) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }

        public static Time parse(String time) {
            int[] timeInfo = Arrays.stream(time.split(":"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            return new Time(timeInfo[0], timeInfo[1], timeInfo[2]);
        }

        public Time subtract(Time time) {
            int secondsDifference = this.second - time.second;
            int minuteDifference = this.minute - time.minute;
            int hourDifference = this.hour - time.hour;
            if (secondsDifference < 0) {
                secondsDifference += 60;
                minuteDifference--;
            }
            if (minuteDifference < 0) {
                minuteDifference += 60;
                hourDifference--;
            }
            if (hourDifference < 0) {
                hourDifference += 24;
            }
            return new Time(hourDifference, minuteDifference, secondsDifference);
        }

        @Override
        public String toString() {
            return String.format("%02d:%02d:%02d", this.hour, this.minute, this.second);
        }
    }
}
