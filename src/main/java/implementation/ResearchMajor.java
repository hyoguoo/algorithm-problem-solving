/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 28289
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ResearchMajor {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int studentCount = Integer.parseInt(bufferedReader.readLine());
        Student[] students = new Student[studentCount];

        for (int i = 0; i < studentCount; i++) {
            int[] studentInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            students[i] = new Student(studentInfo[0], studentInfo[1]);
        }

        System.out.print(solution(students));
    }

    private static ResearchResult solution(Student[] students) {
        int software = 0;
        int embedded = 0;
        int artificialIntelligence = 0;
        int independent = 0;

        for (Student student : students) {
            if (student.grade == 1) {
                independent++;
            } else if (student.classNumber == 1 || student.classNumber == 2) {
                software++;
            } else if (student.classNumber == 3) {
                embedded++;
            } else if (student.classNumber == 4) {
                artificialIntelligence++;
            }
        }

        return new ResearchResult(software, embedded, artificialIntelligence, independent);
    }

    static class ResearchResult {

        private final int software;
        private final int embedded;
        private final int artificialIntelligence;
        private final int independent;

        public ResearchResult(int software, int embedded, int artificialIntelligence, int independent) {
            this.software = software;
            this.embedded = embedded;
            this.artificialIntelligence = artificialIntelligence;
            this.independent = independent;
        }

        @Override
        public String toString() {
            return software + "\n" +
                    embedded + "\n" +
                    artificialIntelligence + "\n" +
                    independent;
        }
    }

    static class Student {

        private final int grade;
        private final int classNumber;

        public Student(int grade, int classNumber) {
            this.grade = grade;
            this.classNumber = classNumber;
        }
    }
}
