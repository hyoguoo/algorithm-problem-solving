/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15702
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MidtermGrading {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] firstLine = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int problemCount = firstLine[0];
        int studentCount = firstLine[1];

        int[] problemScores = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Student[] students = new Student[studentCount];
        for (int i = 0; i < studentCount; i++) {
            String[] studentData = bufferedReader.readLine().split(" ");
            int studentId = Integer.parseInt(studentData[0]);
            List<GradingResult> results = new ArrayList<>();
            for (int j = 0; j < problemCount; j++) {
                results.add(GradingResult.of(studentData[j + 1]));
            }
            students[i] = new Student(studentId, new AnswerSheet(results), problemScores);
        }

        System.out.println(solution(students));
    }

    private static Result solution(Student[] students) {
        Student winner = Arrays.stream(students)
                .max(Comparator.comparingInt((Student student) -> student.totalScore)
                        .thenComparing(Comparator.comparingInt((Student student) -> student.id).reversed()))
                .orElseThrow();

        return new Result(winner.id, winner.totalScore);
    }

    enum GradingResult {
        O, X;

        public static GradingResult of(String result) {
            return GradingResult.valueOf(result);
        }

        public boolean isCorrect() {
            return this == O;
        }
    }

    static class AnswerSheet {

        private final List<GradingResult> results;

        public AnswerSheet(List<GradingResult> results) {
            this.results = results;
        }

        public int calculateScore(int[] problemScores) {
            int totalScore = 0;
            for (int i = 0; i < results.size(); i++) {
                if (results.get(i).isCorrect()) {
                    totalScore += problemScores[i];
                }
            }
            return totalScore;
        }
    }

    static class Student {

        final int id;
        final int totalScore;

        public Student(int id, AnswerSheet answerSheet, int[] problemScores) {
            this.id = id;
            this.totalScore = answerSheet.calculateScore(problemScores);
        }
    }

    static class Result {

        private final int studentId;
        private final int score;

        public Result(int studentId, int score) {
            this.studentId = studentId;
            this.score = score;
        }

        @Override
        public String toString() {
            return studentId + " " + score;
        }
    }
}
