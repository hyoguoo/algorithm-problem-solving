/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 34981
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WaitingForBus {

    private static final int MINUTE_LIMIT = 1440;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] arrivalTimeInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int arrivalTime = arrivalTimeInfo[0] * 60 + arrivalTimeInfo[1];

        int busLineCount = Integer.parseInt(bufferedReader.readLine());
        BusLine[] busLines = new BusLine[busLineCount];

        for (int i = 0; i < busLineCount; i++) {
            int[] busLineInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int firstBusTime = busLineInfo[0] * 60 + busLineInfo[1];
            int interval = busLineInfo[2];
            busLines[i] = new BusLine(firstBusTime, interval);
        }

        int minutes = solution(busLines, arrivalTime);
        System.out.printf("%02d:%02d", minutes / 60, minutes % 60);
    }

    private static int solution(BusLine[] busLines, int arrivalTime) {
        int minWaitTime = Arrays.stream(busLines)
                .mapToInt(busLine -> calculateWaitTime(busLine, arrivalTime))
                .min()
                .orElseThrow(IllegalArgumentException::new);

        return (arrivalTime + minWaitTime) % MINUTE_LIMIT;
    }

    private static int calculateWaitTime(BusLine busLine, int arrivalTime) {
        int firstBus = busLine.getFirstBusTime();
        int interval = busLine.getInterval();

        if (arrivalTime <= firstBus) {
            return firstBus - arrivalTime;
        }

        int elapsedSinceFirst = arrivalTime - firstBus;
        int remaining = (interval - (elapsedSinceFirst % interval)) % interval;
        int nextBusTime = arrivalTime + remaining;

        if (nextBusTime >= MINUTE_LIMIT) {
            return (MINUTE_LIMIT - arrivalTime) + firstBus;
        }

        return remaining;
    }

    static class BusLine {

        private final int firstBusTime;
        private final int interval;

        public BusLine(int firstBusTime, int interval) {
            this.firstBusTime = firstBusTime;
            this.interval = interval;
        }

        public int getFirstBusTime() {
            return firstBusTime;
        }

        public int getInterval() {
            return interval;
        }
    }
}
