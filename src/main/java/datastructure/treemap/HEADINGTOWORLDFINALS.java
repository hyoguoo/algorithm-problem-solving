/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10981
 * Cheat Level: 0
 * Algorithm: Tree Map
 */

package datastructure.treemap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.TreeMap;

public class HEADINGTOWORLDFINALS {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int teamCount = info[0];
        int entryCount = info[1];

        TeamInfo[] teamInfos = new TeamInfo[teamCount];

        for (int i = 0; i < teamCount; i++) {
            String[] teamInfo = bufferedReader.readLine().split(" ");
            String university = teamInfo[0];
            String teamName = teamInfo[1];
            int solved = Integer.parseInt(teamInfo[2]);
            int penalty = Integer.parseInt(teamInfo[3]);
            teamInfos[i] = new TeamInfo(university, teamName, solved, penalty);
        }

        System.out.print(solution(teamInfos, entryCount));
    }

    private static String solution(TeamInfo[] teamInfos, int entryCount) {
        TreeMap<String, TeamInfo> universityMap = new TreeMap<>();

        Arrays.stream(teamInfos)
                .forEach(teamInfo -> {
                    universityMap.computeIfAbsent(teamInfo.university, key -> teamInfo);
                    universityMap.replace(teamInfo.university,
                            universityMap.get(teamInfo.university).compareTo(teamInfo) > 0
                                    ? teamInfo
                                    : universityMap.get(teamInfo.university));
                });

        return universityMap.values().stream()
                .sorted()
                .limit(entryCount)
                .map(teamInfo -> teamInfo.teamName)
                .reduce((s1, s2) -> s1 + "\n" + s2)
                .orElse("");
    }

    static class TeamInfo implements Comparable<TeamInfo> {

        private final String university;
        private final String teamName;
        private final int solved;
        private final int penalty;

        public TeamInfo(String university, String teamName, int solved, int penalty) {
            this.university = university;
            this.teamName = teamName;
            this.solved = solved;
            this.penalty = penalty;
        }

        @Override
        public int compareTo(TeamInfo other) {
            if (this.solved == other.solved) {
                return Integer.compare(this.penalty, other.penalty);
            }
            return Integer.compare(other.solved, this.solved);
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            TeamInfo teamInfo = (TeamInfo) o;
            return solved == teamInfo.solved && penalty == teamInfo.penalty &&
                    Objects.equals(university, teamInfo.university) && Objects.equals(teamName, teamInfo.teamName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(university, teamName, solved, penalty);
        }
    }
}
