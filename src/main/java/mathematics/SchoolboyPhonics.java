/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 28097
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SchoolboyPhonics {

    private static final int REST_HOUR = 8;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] studyHourPlans = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(studyHourPlans));
    }

    private static Time solution(int[] studyHourPlans) {
        int totalHour = Arrays.stream(studyHourPlans).sum();
        totalHour += REST_HOUR * (studyHourPlans.length - 1);

        return new Time(totalHour);
    }


    static class Time {

        private static final int DAY_HOUR = 24;
        private final int day;
        private final int hour;

        public Time(int hour) {
            this.day = hour / DAY_HOUR;
            this.hour = hour % DAY_HOUR;
        }

        @Override
        public String toString() {
            return day + " " + hour;
        }
    }
}
