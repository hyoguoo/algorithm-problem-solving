/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2755
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class WhatGPASemester {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int subjectCount = Integer.parseInt(bufferedReader.readLine());
        Subject[] subjects = new Subject[subjectCount];

        for (int i = 0; i < subjectCount; i++) {
            String[] arr = bufferedReader.readLine().split(" ");
            int credit = Integer.parseInt(arr[1]);
            Grade grade = Grade.from(arr[2]); // enum 변환
            subjects[i] = new Subject(credit, grade);
        }

        System.out.print(solution(subjects).setScale(2, RoundingMode.HALF_UP));
    }

    private static BigDecimal solution(Subject[] subjects) {
        BigDecimal totalScore = BigDecimal.ZERO;
        BigDecimal totalCredit = BigDecimal.ZERO;

        for (Subject s : subjects) {
            BigDecimal credit = BigDecimal.valueOf(s.credit);
            BigDecimal score = BigDecimal.valueOf(s.grade.score);
            totalScore = totalScore.add(credit.multiply(score));
            totalCredit = totalCredit.add(credit);
        }

        return totalScore.divide(totalCredit, 2, RoundingMode.HALF_UP);
    }

    enum Grade {
        A_PLUS("A+", 4.3),
        A_ZERO("A0", 4.0),
        A_MINUS("A-", 3.7),
        B_PLUS("B+", 3.3),
        B_ZERO("B0", 3.0),
        B_MINUS("B-", 2.7),
        C_PLUS("C+", 2.3),
        C_ZERO("C0", 2.0),
        C_MINUS("C-", 1.7),
        D_PLUS("D+", 1.3),
        D_ZERO("D0", 1.0),
        D_MINUS("D-", 0.7),
        F("F", 0.0);

        private final double score;
        private final String text;

        Grade(String text, double score) {
            this.text = text;
            this.score = score;
        }

        public static Grade from(String s) {
            return Arrays.stream(Grade.values())
                    .filter(grade -> grade.text.equals(s))
                    .findFirst()
                    .orElseThrow();
        }
    }

    static class Subject {

        final int credit;
        final Grade grade;

        Subject(int credit, Grade grade) {
            this.credit = credit;
            this.grade = grade;
        }
    }
}
