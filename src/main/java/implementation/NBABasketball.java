/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2852
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NBABasketball {

    private static final int TEAM_COUNT = 2;
    private static final Time GAME_TIME = new Time(48, 0);

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int goalCount = Integer.parseInt(bufferedReader.readLine());
        GoalQuery[] goalQueries = new GoalQuery[goalCount];

        for (int i = 0; i < goalCount; i++) {
            goalQueries[i] = new GoalQuery(bufferedReader.readLine());
        }

        System.out.print(solution(goalQueries));
    }

    private static String solution(GoalQuery[] goalQueries) {
        Time[] winTime = new Time[TEAM_COUNT + 1];
        int[] goalCount = new int[TEAM_COUNT + 1];
        Time currentTime = new Time();
        for (int i = 0; i < TEAM_COUNT + 1; i++) {
            winTime[i] = new Time();
        }
        for (GoalQuery goalQuery : goalQueries) {
            Time diffTime = goalQuery.time.diff(currentTime);
            int winningTeam = getWinningTeam(goalCount);
            winTime[winningTeam] = winTime[winningTeam].add(diffTime);
            goalCount[goalQuery.team]++;
            currentTime = goalQuery.time;
        }

        int winningTeam = getWinningTeam(goalCount);
        winTime[winningTeam] = winTime[winningTeam].add(GAME_TIME.diff(currentTime));

        return winTime[1] + "\n" + winTime[2];
    }

    private static int getWinningTeam(int[] goalCount) {
        if (goalCount[1] > goalCount[2]) {
            return 1;
        } else if (goalCount[1] < goalCount[2]) {
            return 2;
        } else {
            return 0;
        }
    }

    static class GoalQuery {

        private final int team;
        private final Time time;

        public GoalQuery(String query) {
            String[] split = query.split(" ");
            this.team = Integer.parseInt(split[0]);
            this.time = new Time(split[1]);
        }
    }

    static class Time {

        private final int minute;
        private final int second;
        public Time() {
            this(0, 0);
        }

        public Time(String time) {
            String[] split = time.split(":");
            this.minute = Integer.parseInt(split[0]);
            this.second = Integer.parseInt(split[1]);
        }

        public Time(int minute, int second) {
            this.minute = minute;
            this.second = second;
        }

        public Time diff(Time time) {
            if (!this.isGreaterThan(time)) {
                throw new IllegalArgumentException();
            }

            int diffMinute = this.minute - time.minute;
            int diffSecond = this.second - time.second;

            if (diffSecond < 0) {
                diffMinute--;
                diffSecond += 60;
            }

            return new Time(diffMinute, diffSecond);
        }

        public Time add(Time time) {
            int addMinute = this.minute + time.minute;
            int addSecond = this.second + time.second;

            if (addSecond >= 60) {
                addMinute++;
                addSecond -= 60;
            }

            return new Time(addMinute, addSecond);
        }

        private boolean isGreaterThan(Time time) {
            return this.minute > time.minute ||
                    (this.minute == time.minute && this.second > time.second);
        }

        @Override
        public String toString() {
            return String.format("%02d:%02d", minute, second);
        }
    }
}
