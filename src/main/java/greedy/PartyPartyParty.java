/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4055
 * Cheat Level: 0
 * Algorithm: Greedy / Sort
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PartyPartyParty {

    private static final int START_TIME = 8;
    private static final int END_TIME = 23;
    private static final int DAILY_SLOTS = 2;
    private static final String PRINT_FORMAT = "On day %d Emma can attend as many as %d parties.";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int day = 1;

        while (true) {
            int partyCount = Integer.parseInt(bufferedReader.readLine());
            if (partyCount == 0) {
                break;
            }

            List<Party> parties = new ArrayList<>();
            for (int i = 0; i < partyCount; i++) {
                int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                int start = info[0];
                int end = info[1] - 1;

                if (start <= end) {
                    parties.add(new Party(start, end));
                }
            }

            stringBuilder.append(String.format(PRINT_FORMAT, day++, solution(parties))).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(List<Party> parties) {
        Collections.sort(parties);
        int count = 0;

        for (int time = START_TIME; time <= END_TIME; time++) {
            for (int slot = 0; slot < DAILY_SLOTS; slot++) {
                for (int i = 0; i < parties.size(); i++) {
                    Party current = parties.get(i);
                    if (current.isInTimeSlot(time)) {
                        count++;
                        parties.remove(i);
                        break;
                    }
                }
            }
        }

        return count;
    }

    static class Party implements Comparable<Party> {

        private final int startTime;
        private final int endTime;

        public Party(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public boolean isInTimeSlot(int time) {
            return startTime <= time && time <= endTime;
        }

        @Override
        public int compareTo(Party other) {
            if (this.endTime == other.endTime) {
                return Integer.compare(this.startTime, other.startTime);
            }
            return Integer.compare(this.endTime, other.endTime);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Party party = (Party) obj;
            return startTime == party.startTime && endTime == party.endTime;
        }

        @Override
        public int hashCode() {
            return Objects.hash(startTime, endTime);
        }
    }
}
