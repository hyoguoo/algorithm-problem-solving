/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 7507
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class OlympicGames {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        for (int t = 1; t <= testCount; t++) {
            int gameCount = Integer.parseInt(bufferedReader.readLine());
            Game[] games = new Game[gameCount];

            for (int i = 0; i < gameCount; i++) {
                String[] info = bufferedReader.readLine().split(" ");
                int day = Integer.parseInt(info[0]);
                String[] startTimeInfo = info[1].split("(?<=\\G.{2})");
                String[] endTimeInfo = info[2].split("(?<=\\G.{2})");
                Time startTime = new Time(Integer.parseInt(startTimeInfo[0]), Integer.parseInt(startTimeInfo[1]));
                Time endTime = new Time(Integer.parseInt(endTimeInfo[0]), Integer.parseInt(endTimeInfo[1]));

                games[i] = new Game(day, startTime, endTime);
            }
            stringBuilder.append(String.format("Scenario #%d:", t))
                    .append("\n")
                    .append(solution(games))
                    .append("\n\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(Game[] games) {
        Arrays.sort(games, (a, b) -> {
            if (a.day != b.day) {
                return Integer.compare(a.day, b.day);
            }
            int aEnd = a.endTime.toMinutes();
            int bEnd = b.endTime.toMinutes();
            return Integer.compare(aEnd, bEnd);
        });

        int count = 0;
        int currentDay = -1;
        int currentTime = -1;

        for (Game game : games) {
            int startMinutes = game.startTime.toMinutes();
            int endMinutes = game.endTime.toMinutes();

            if (game.day != currentDay || startMinutes >= currentTime) {
                count++;
                currentDay = game.day;
                currentTime = endMinutes;
            }
        }

        return count;
    }

    static class Game {

        private final int day;
        private final Time startTime;
        private final Time endTime;

        public Game(int day, Time startTime, Time endTime) {
            this.day = day;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    static class Time {

        private final int hour;
        private final int minute;

        public Time(int hour, int minute) {
            this.hour = hour;
            this.minute = minute;
        }

        public int toMinutes() {
            return hour * 60 + minute;
        }
    }
}
