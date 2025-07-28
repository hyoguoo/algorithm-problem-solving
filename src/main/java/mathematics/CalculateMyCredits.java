/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10984
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculateMyCredits {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            int subjectCount = Integer.parseInt(bufferedReader.readLine());

            Subject[] subjects = new Subject[subjectCount];

            for (int s = 0; s < subjectCount; s++) {
                String[] subjectInfo = bufferedReader.readLine().split(" ");
                int credit = Integer.parseInt(subjectInfo[0]);
                double grade = Double.parseDouble(subjectInfo[1]);
                subjects[s] = new Subject(credit, grade);
            }

            stringBuilder.append(solution(subjects))
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static Result solution(Subject[] subjects) {
        int totalCredits = 0;
        double totalGradePoints = 0.0;

        for (Subject subject : subjects) {
            totalCredits += subject.credit;
            totalGradePoints += subject.credit * subject.grade;
        }

        return new Result(totalCredits, totalGradePoints);
    }

    static class Subject {

        private final int credit;
        private final double grade;

        public Subject(int credit, double grade) {
            this.credit = credit;
            this.grade = grade;
        }
    }

    static class Result {

        private final int totalCredits;
        private final double totalGradePoints;

        public Result(int totalCredits, double totalGradePoints) {
            this.totalCredits = totalCredits;
            this.totalGradePoints = totalGradePoints;
        }

        public double getGPA() {
            return totalGradePoints / totalCredits;
        }

        @Override
        public String toString() {
            return String.format("%d %.1f", totalCredits, getGPA());
        }
    }
}
