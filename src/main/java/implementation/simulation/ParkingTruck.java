/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2979
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ParkingTruck {

    private static final int TRUCK_COUNT = 3;
    private static final int TIME_LIMIT = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] feeInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] fees = new int[TRUCK_COUNT + 1];
        System.arraycopy(feeInfo, 0, fees, 1, fees.length - 1);


        Parking[] parkingInfos = new Parking[TRUCK_COUNT];

        for (int i = 0; i < TRUCK_COUNT; i++) {
            int[] parkingInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            parkingInfos[i] = new Parking(parkingInfo[0], parkingInfo[1]);
        }

        System.out.print(solution(fees, parkingInfos));
    }

    private static int solution(int[] fees, Parking[] parkingInfos) {
        int[] parkingTime = new int[TIME_LIMIT + 1];

        for (Parking parking : parkingInfos) {
            for (int i = parking.entryTime; i < parking.exitTime; i++) {
                parkingTime[i]++;
            }
        }

        int totalFee = 0;

        for (int i = 1; i < parkingTime.length; i++) {
            totalFee += fees[parkingTime[i]] * parkingTime[i];
        }

        return totalFee;
    }

    static class Parking {

        private final int entryTime;
        private final int exitTime;

        public Parking(int entryTime, int exitTime) {
            this.entryTime = entryTime;
            this.exitTime = exitTime;
        }
    }
}
