/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5575
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class TimeCard {

    private static final int PEOPLE_COUNT = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < PEOPLE_COUNT; i++) {
            int[] timeInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            LocalTime startTime = LocalTime.of(timeInfo[0], timeInfo[1], timeInfo[2]);
            LocalTime endTime = LocalTime.of(timeInfo[3], timeInfo[4], timeInfo[5]);

            stringBuilder
                    .append(solution(startTime, endTime))
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static Result solution(LocalTime startTime, LocalTime endTime) {
        return new Result(LocalTime.ofSecondOfDay(ChronoUnit.SECONDS.between(startTime, endTime)));
    }

    static class Result {

        private final LocalTime localTime;

        public Result(LocalTime localTime) {
            this.localTime = localTime;
        }

        @Override
        public String toString() {
            return String.format("%d %d %d", localTime.getHour(), localTime.getMinute(), localTime.getSecond());
        }
    }
}
