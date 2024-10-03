/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1268
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PickTempCaptain {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int studentCount = Integer.parseInt(bufferedReader.readLine());

        Student[] students = new Student[studentCount];

        for (int i = 0; i < studentCount; i++) {
            int[] classes = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            students[i] = new Student(i + 1, classes);
        }

        System.out.print(solution(students));
    }

    private static int solution(Student[] students) {
        int[] overlapCount = getOverlapCount(students);

        return getMaxIndex(overlapCount) + 1;
    }

    private static int[] getOverlapCount(Student[] students) {
        return Arrays.stream(students)
                .mapToInt(student -> student.getCountOfOverlappingClasses(students))
                .toArray();
    }

    private static int getMaxIndex(int[] overlapCount) {
        int max = 0;
        int maxIndex = 0;

        for (int i = 0; i < overlapCount.length; i++) {
            if (overlapCount[i] > max) {
                max = overlapCount[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    static class Student {

        private final int id;
        private final int[] classes;

        public Student(int id, int[] classes) {
            this.id = id;
            this.classes = classes;
        }

        public int getCountOfOverlappingClasses(Student[] students) {
            int overlapCount = 0;

            for (Student otherStudent : students) {
                if (this.id != otherStudent.id && hasSharedClassWith(otherStudent)) {
                    overlapCount++;
                }
            }

            return overlapCount;
        }

        private boolean hasSharedClassWith(Student otherStudent) {
            for (int g = 0; g < classes.length; g++) {
                if (this.classes[g] == otherStudent.classes[g]) {
                    return true;
                }
            }
            return false;
        }
    }
}
