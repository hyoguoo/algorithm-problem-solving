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
import java.util.Arrays;

public class YourRating {

    static final int SUBJECT_COUNT = 20;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Subject[] subjects = new Subject[SUBJECT_COUNT];
        for (int s = 0; s < SUBJECT_COUNT; s++) {
            String[] input = bufferedReader.readLine().split(" ");
            subjects[s] = new Subject(Double.parseDouble(input[1]), Grade.of(input[2]));
        }

        System.out.printf("%.6f", solution(subjects));
    }

    private static double solution(Subject[] subjects) {
        return Arrays.stream(subjects)
                .filter(s -> !s.isGradePass())
                .map(s -> new Rate(s.credit, s.getWeightedScore()))
                .reduce(new Rate(0, 0), Rate::add)
                .getRate();
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
        F("F", 0.0),
        P("P", 0.0);

        private final String gradeString;
        private final double score;

        Grade(String gradeString, double score) {
            this.gradeString = gradeString;
            this.score = score;
        }

        public static Grade of(String grade) {
            return Arrays.stream(Grade.values())
                    .filter(g -> g.gradeString.equals(grade))
                    .findFirst()
                    .orElseThrow();
        }
    }

    static class Rate {

        private final double totalCredit;
        private final double totalScore;

        public Rate(double totalCredit, double totalScore) {
            this.totalCredit = totalCredit;
            this.totalScore = totalScore;
        }

        public Rate add(Rate rate) {
            return new Rate(
                    totalCredit + rate.totalCredit,
                    totalScore + rate.totalScore
            );
        }

        public double getRate() {
            return totalScore / totalCredit;
        }
    }

    static class Subject {

        private final double credit;
        private final Grade grade;

        public Subject(double credit, Grade grade) {
            this.credit = credit;
            this.grade = grade;
        }

        public double getWeightedScore() {
            if (isGradePass()) {
                throw new IllegalArgumentException();
            }
            return credit * grade.score;
        }

        private boolean isGradePass() {
            return grade == Grade.P;
        }
    }
}
