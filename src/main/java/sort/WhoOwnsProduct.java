/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 24509
 * Cheat Level: 0
 * Algorithm: Implementation / Sort
 */

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;

public class WhoOwnsProduct {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int studentCount = Integer.parseInt(bufferedReader.readLine());

        StudentScore[] studentScores = new StudentScore[studentCount];

        for (int i = 0; i < studentCount; i++) {
            int[] studentInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            studentScores[i] = new StudentScore(
                    studentInfo[0],
                    studentInfo[1],
                    studentInfo[2],
                    studentInfo[3],
                    studentInfo[4]
            );
        }

        System.out.print(solution(studentScores));
    }

    private static Result solution(StudentScore[] studentScores) {
        Set<Integer> ownedStudentNumbers = new HashSet<>();
        EnumMap<Subject, Integer> winners = new EnumMap<>(Subject.class);

        Arrays.stream(Subject.ordered())
                .forEach(subject -> {
                    StudentScore top = topBy(studentScores, subject, ownedStudentNumbers);
                    ownedStudentNumbers.add(top.studentNumber);
                    winners.put(subject, top.studentNumber);
                });

        return new Result(
                winners.get(Subject.KOREAN),
                winners.get(Subject.ENGLISH),
                winners.get(Subject.MATH),
                winners.get(Subject.SCIENCE)
        );
    }

    private static StudentScore topBy(StudentScore[] studentScores,
            Subject subject,
            Set<Integer> excludedStudentNumbers) {
        return Arrays.stream(studentScores)
                .filter(s -> !excludedStudentNumbers.contains(s.studentNumber))
                .min(comparatorFor(subject))
                .orElseThrow();
    }

    private static Comparator<StudentScore> comparatorFor(Subject subject) {
        return Comparator
                .comparingInt((StudentScore s) -> scoreOf(s, subject)).reversed()
                .thenComparingInt(s -> s.studentNumber);
    }

    private static int scoreOf(StudentScore s, Subject subject) {
        switch (subject) {
            case KOREAN:
                return s.korean;
            case ENGLISH:
                return s.english;
            case MATH:
                return s.math;
            case SCIENCE:
                return s.science;
            default:
                throw new IllegalArgumentException();
        }
    }

    private enum Subject {
        KOREAN(0),
        ENGLISH(1),
        MATH(2),
        SCIENCE(3);

        private final int order;

        Subject(int order) {
            this.order = order;
        }

        static Subject[] ordered() {
            return Arrays.stream(values())
                    .sorted(Comparator.comparingInt(s -> s.order))
                    .toArray(Subject[]::new);
        }
    }

    static class Result {

        private final int koreanBestStudentNumber;
        private final int englishBestStudentNumber;
        private final int mathBestStudentNumber;
        private final int scienceBestStudentNumber;

        public Result(int koreanBestStudentNumber, int englishBestStudentNumber, int mathBestStudentNumber,
                int scienceBestStudentNumber) {
            this.koreanBestStudentNumber = koreanBestStudentNumber;
            this.englishBestStudentNumber = englishBestStudentNumber;
            this.mathBestStudentNumber = mathBestStudentNumber;
            this.scienceBestStudentNumber = scienceBestStudentNumber;
        }

        @Override
        public String toString() {
            return String.format("%d %d %d %d",
                    koreanBestStudentNumber,
                    englishBestStudentNumber,
                    mathBestStudentNumber,
                    scienceBestStudentNumber);
        }
    }

    static class StudentScore {

        private final int studentNumber;
        private final int korean;
        private final int english;
        private final int math;
        private final int science;

        public StudentScore(int studentNumber, int korean, int english, int math, int science) {
            this.studentNumber = studentNumber;
            this.korean = korean;
            this.english = english;
            this.math = math;
            this.science = science;
        }
    }
}
