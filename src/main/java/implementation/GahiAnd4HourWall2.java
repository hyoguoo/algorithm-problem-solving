/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 32776
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GahiAnd4HourWall2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int railTime = Integer.parseInt(bufferedReader.readLine());
        int[] flightData = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        TravelInfo travelInfo = new TravelInfo(railTime, new FlightInfo(flightData[0], flightData[1], flightData[2]));

        System.out.print(solution(travelInfo));
    }

    private static TransportType solution(TravelInfo travelInfo) {
        if (travelInfo.getRailTime() <= travelInfo.getFlightInfo().getTotalTime() || travelInfo.getRailTime() <= 240) {
            return TransportType.HIGH_SPEED_RAIL;
        }
        return TransportType.FLIGHT;
    }

    enum TransportType {
        HIGH_SPEED_RAIL("high speed rail"),
        FLIGHT("flight");

        private final String value;

        TransportType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }

    static class TravelInfo {

        private final int railTime;
        private final FlightInfo flightInfo;

        public TravelInfo(int railTime, FlightInfo flightInfo) {
            this.railTime = railTime;
            this.flightInfo = flightInfo;
        }

        public int getRailTime() {
            return railTime;
        }

        public FlightInfo getFlightInfo() {
            return flightInfo;
        }
    }

    static class FlightInfo {

        private final int ma;
        private final int fab;
        private final int mb;

        public FlightInfo(int ma, int fab, int mb) {
            this.ma = ma;
            this.fab = fab;
            this.mb = mb;
        }

        public int getTotalTime() {
            return ma + fab + mb;
        }
    }
}
