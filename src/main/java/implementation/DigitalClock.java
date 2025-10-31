/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1942
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.Arrays;

public class DigitalClock {

    private static final int TEST_CASE_COUNT = 3;
    private static final int MULTIPLE_VALUE = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < TEST_CASE_COUNT; i++) {
            LocalTime[] localTimes = Arrays.stream(bufferedReader.readLine().split(" "))
                    .map(LocalTime::parse)
                    .toArray(LocalTime[]::new);

            stringBuilder
                    .append(solution(localTimes[0], localTimes[1]))
                    .append(System.lineSeparator());
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(LocalTime localTime1, LocalTime localTime2) {
        int count = 0;
        LocalTime currentTime = localTime1;

        while (true) {
            if (convertToInteger(currentTime) % MULTIPLE_VALUE == 0) {
                count++;
            }
            if (currentTime.equals(localTime2)) {
                break;
            }
            currentTime = currentTime.plusSeconds(1);
        }

        return count;
    }

    private static int convertToInteger(LocalTime localTime) {
        return localTime.getHour() * 10000 + localTime.getMinute() * 100 + localTime.getSecond();
    }
}
