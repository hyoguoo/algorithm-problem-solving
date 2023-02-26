/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 27522
 * Cheat Level: 0
 * Algorithm: Sort
 */

package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KartRiderDrift {

    final static int LENGTH = 8;
    final static int[] SCORE = {10, 8, 6, 5, 4, 3, 2, 1};
    static int redScore = 0;
    static int blueScore = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Record[] records = new Record[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            int[] record = Arrays.stream(line[0].split(":")).mapToInt(Integer::parseInt).toArray();
            TEAM team = TEAM.valueOf(line[1]);
            records[i] = new Record(record[0], record[1], record[2], team);
        }

        System.out.println(solution(records));
    }

    private static String solution(Record[] records) {
        Arrays.sort(records);
        for (int i = 0; i < LENGTH; i++) {
            if (records[i].team == TEAM.R) redScore += SCORE[i];
            else blueScore += SCORE[i];
        }

        return redScore > blueScore ? "Red" : "Blue";
    }

    enum TEAM {
        R, B
    }

    static class Record implements Comparable<Record> {
        Enum<TEAM> team;
        int minute;
        int second;
        int millisecond;


        public Record(int minute, int second, int millisecond, TEAM team) {
            this.minute = minute;
            this.second = second;
            this.millisecond = millisecond;
            this.team = team;
        }

        @Override
        public int compareTo(Record o) {
            if (this.minute != o.minute) return this.minute - o.minute;
            if (this.second != o.second) return this.second - o.second;
            return this.millisecond - o.millisecond;
        }
    }
}
