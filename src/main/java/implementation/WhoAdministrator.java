/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14724
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class WhoAdministrator {

    private static final String[] CLUB_NAMES = {
            "PROBRAIN",
            "GROW",
            "ARGOS",
            "ADMIN",
            "ANT",
            "MOTION",
            "SPG",
            "COMON",
            "ALMIGHTY"
    };

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        ClubInfo[] clubInfos = new ClubInfo[CLUB_NAMES.length];

        for (int i = 0; i < CLUB_NAMES.length; i++) {
            int[] solvedCounts = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            clubInfos[i] = new ClubInfo(CLUB_NAMES[i], solvedCounts);
        }

        System.out.print(solution(clubInfos));
    }

    private static ClubInfo solution(ClubInfo[] clubInfos) {
        return Arrays.stream(clubInfos)
                .max(Comparator.comparingInt(ClubInfo::getMaxSolvedCount))
                .orElseThrow();
    }

    static class ClubInfo {

        private final String clubName;
        private final int[] solvedCounts;

        public ClubInfo(String clubName, int[] solvedCounts) {
            this.clubName = clubName;
            this.solvedCounts = solvedCounts;
        }

        public int getMaxSolvedCount() {
            return Arrays.stream(solvedCounts).max().orElse(0);
        }

        @Override
        public String toString() {
            return clubName;
        }
    }
}
