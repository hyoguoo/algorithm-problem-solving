/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17843
 * Cheat Level: 0
 * Algorithm: Mathematics / Geometry
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Clock {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            int[] timeInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            stringBuilder.append(solution(new Time(timeInfo[0], timeInfo[1], timeInfo[2]))).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static double solution(Time time) {
        int h = time.hour;
        int m = time.minute;
        int s = time.second;
        double hourAngle = (h % 12 + m / 60.0 + s / 3600.0) * 30;
        double minuteAngle = (m + s / 60.0) * 6;
        double secondAngle = s * 6;

        return Math.min(
                angleDifference(hourAngle, minuteAngle),
                Math.min(
                        angleDifference(hourAngle, secondAngle),
                        angleDifference(minuteAngle, secondAngle)
                )
        );
    }

    private static double angleDifference(double angle1, double angle2) {
        double diff = Math.abs(angle1 - angle2);
        return Math.min(diff, 360 - diff);
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
    }
}
