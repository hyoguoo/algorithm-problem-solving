/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1590
 * Cheat Level: 0
 * Algorithm: Binary Search
 */

package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class YoungsikGoingCamp {

    private static final int NOT_FOUND = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int busCount = Integer.parseInt(stringTokenizer.nextToken());
        int arrivalTime = Integer.parseInt(stringTokenizer.nextToken());

        Bus[] buses = new Bus[busCount];

        for (int i = 0; i < busCount; i++) {
            int[] busInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            buses[i] = new Bus(busInfo[0], busInfo[1], busInfo[2]);
        }

        System.out.println(solution(buses, arrivalTime));
    }

    private static long solution(Bus[] buses, int arrivalTime) {
        long minWaitingTime = Long.MAX_VALUE;

        for (Bus bus : buses) {
            long earliestDeparture = bus.getEarliestDeparture(arrivalTime);

            if (earliestDeparture != NOT_FOUND) {
                minWaitingTime = Math.min(minWaitingTime, earliestDeparture - arrivalTime);
            }
        }

        return minWaitingTime == Long.MAX_VALUE
                ? NOT_FOUND
                : minWaitingTime;
    }


    static class Bus {

        private final int startTime;
        private final int interval;
        private final int totalTrips;

        public Bus(int startTime, int interval, int totalTrips) {
            this.startTime = startTime;
            this.interval = interval;
            this.totalTrips = totalTrips;
        }

        public long getEarliestDeparture(int arrivalTime) {
            int left = 0;
            int right = this.totalTrips - 1;
            long result = NOT_FOUND;

            while (left <= right) {
                int mid = (left + right) / 2;
                long departureTime = this.startTime + (long) mid * this.interval;

                if (departureTime >= arrivalTime) {
                    result = departureTime;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return result;
        }
    }
}
