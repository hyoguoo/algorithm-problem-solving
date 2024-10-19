/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2535
 * Cheat Level: 0
 * Algorithm: Sort
 */

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AsiaOlympiadInformatics {

    private static final int WINNER_COUNTRY_LIMIT = 2;
    private static final int WINNER_COUNT = 3;
    private static final int COUNTRY_COUNT = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int peopleCount = Integer.parseInt(bufferedReader.readLine());
        ScoreRecord[] scoreRecords = new ScoreRecord[peopleCount];

        for (int i = 0; i < peopleCount; i++) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            scoreRecords[i] = new ScoreRecord(info[0], info[1], info[2]);
        }

        System.out.print(solution(scoreRecords));
    }

    private static String solution(ScoreRecord[] scoreRecords) {
        int[] winnerCountryCount = new int[COUNTRY_COUNT + 1];
        Arrays.sort(scoreRecords, (a, b) -> b.score - a.score);

        StringBuilder stringBuilder = new StringBuilder();
        int winnerCount = 0;
        for (ScoreRecord scoreRecord : scoreRecords) {
            if (winnerCountryCount[scoreRecord.country] < WINNER_COUNTRY_LIMIT) {
                winnerCountryCount[scoreRecord.country]++;
                stringBuilder.append(scoreRecord.country).append(" ").append(scoreRecord.student).append("\n");
                winnerCount++;
            }
            if (winnerCount == WINNER_COUNT) {
                break;
            }
        }

        return stringBuilder.toString().trim();
    }

    static class ScoreRecord {

        private final int country;
        private final int student;
        private final int score;

        public ScoreRecord(int country, int student, int score) {
            this.country = country;
            this.student = student;
            this.score = score;
        }
    }
}
