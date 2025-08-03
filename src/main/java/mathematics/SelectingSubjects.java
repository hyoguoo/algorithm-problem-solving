/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11948
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SelectingSubjects {

    private static final int SUBJECT_COUNT = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] scores = new int[SUBJECT_COUNT];

        for (int i = 0; i < SUBJECT_COUNT; i++) {
            scores[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Subject subject = new Subject(scores[0], scores[1], scores[2], scores[3], scores[4], scores[5]);

        System.out.print(solution(subject));
    }

    private static int solution(Subject subject) {
        return subject.getTotalScore();
    }

    static class Subject {

        private final int physics;
        private final int chemistry;
        private final int biology;
        private final int earthScience;
        private final int history;
        private final int geography;

        public Subject(int physics, int chemistry, int biology, int earthScience, int history, int geography) {
            this.physics = physics;
            this.chemistry = chemistry;
            this.biology = biology;
            this.earthScience = earthScience;
            this.history = history;
            this.geography = geography;
        }

        public int getTotalScore() {
            return getScienceScore() + getHumanitiesScore();
        }


        private int getScienceScore() {
            return Arrays.stream(new int[]{physics, chemistry, biology, earthScience})
                    .sorted()
                    .skip(1)
                    .sum();
        }

        private int getHumanitiesScore() {
            return Math.max(history, geography);
        }
    }
}
