/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 25206
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YourRating {

    static final int SUBJECT_COUNT = 20;
    static final String PASS = "P";

    public static void main(String[] args) throws IOException {
        System.out.printf("%.6f", solution());
    }

    private static double solution() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        double rate = 0;
        double totalCredit = 0;

        for (int s = 0; s < SUBJECT_COUNT; s++) {
            String[] input = bufferedReader.readLine().split(" ");
            double score = Double.parseDouble(input[1]);
            String grade = input[2];

            if (grade.equals(PASS)) continue;

            totalCredit += score;
            rate += score * Grade.findScore(grade);
        }

        return rate / (totalCredit == 0 ? 1 : totalCredit);
    }

    enum Grade {
        A_PLUS("A+", 4.5),
        A_ZERO("A0", 4.0),
        B_PLUS("B+", 3.5),
        B_ZERO("B0", 3.0),
        C_PLUS("C+", 2.5),
        C_ZERO("C0", 2.0),
        D_PLUS("D+", 1.5),
        D_ZERO("D0", 1.0),
        F("F", 0.0);

        private final String gradeString;
        private final double score;

        Grade(String gradeString, double score) {
            this.gradeString = gradeString;
            this.score = score;
        }

        public static double findScore(String grade) {
            for (Grade g : values()) {
                if (g.gradeString.equals(grade)) return g.score;
            }
            throw new IllegalArgumentException();
        }
    }
}
