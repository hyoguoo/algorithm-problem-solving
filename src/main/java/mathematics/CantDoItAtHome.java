/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 29734
 * Cheat Level: 0
 * Algorithm: Mathematics / Implementation
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CantDoItAtHome {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long[] firstLine = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        long timeAtHome = firstLine[0];
        long timeAtLibrary = firstLine[1];

        long[] secondLine = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        long travelTime = secondLine[0];
        long sleepTime = secondLine[1];

        System.out.print(solution(timeAtHome, timeAtLibrary, travelTime, sleepTime));
    }

    private static Result solution(long timeAtHome, long timeAtLibrary, long travelTime, long sleepTime) {
        long totalTimeHome = (timeAtHome == 0)
                ? 0
                : timeAtHome + ((timeAtHome - 1) / 8) * sleepTime;

        long totalTimeLibrary = (timeAtLibrary == 0)
                ? 0
                : timeAtLibrary + ((timeAtLibrary - 1) / 8) * (sleepTime + 2 * travelTime) + travelTime;

        return totalTimeHome < totalTimeLibrary
                ? new Result(ResultType.ZIP, totalTimeHome)
                : new Result(ResultType.DOK, totalTimeLibrary);
    }

    enum ResultType {
        ZIP("Zip"),
        DOK("Dok");

        private final String displayName;

        ResultType(String displayName) {
            this.displayName = displayName;
        }

        @Override
        public String toString() {
            return displayName;
        }
    }

    static class Result {

        private final ResultType type;
        private final long time;

        public Result(ResultType type, long time) {
            this.type = type;
            this.time = time;
        }

        @Override
        public String toString() {
            return type + System.lineSeparator() + time;
        }
    }
}
