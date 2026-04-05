/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 28238
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InformationTeacherAmbition {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            String[] availability = bufferedReader.readLine().split(" ");
            int mask = 0;
            for (int j = 0; j < 5; j++) {
                if (availability[j].equals("1")) {
                    mask |= (1 << j);
                }
            }
            students[i] = new Student(mask);
        }

        System.out.print(solution(students));
    }

    private static Result solution(Student[] students) {
        int maxCount = -1;
        int bestMask = 0;

        Day[] days = Day.values();
        for (int i = 0; i < days.length; i++) {
            for (int j = i + 1; j < days.length; j++) {
                int currentMask = (1 << days[i].getIndex()) | (1 << days[j].getIndex());
                int count = 0;
                for (Student student : students) {
                    if (student.canAttend(currentMask)) {
                        count++;
                    }
                }

                if (count > maxCount) {
                    maxCount = count;
                    bestMask = currentMask;
                }
            }
        }

        return new Result(maxCount, bestMask);
    }

    enum Day {
        MONDAY(0),
        TUESDAY(1),
        WEDNESDAY(2),
        THURSDAY(3),
        FRIDAY(4);

        private final int index;

        Day(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }

    static class Result {

        private final int maxCount;
        private final int bestMask;

        public Result(int maxCount, int bestMask) {
            this.maxCount = maxCount;
            this.bestMask = bestMask;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(maxCount).append("\n");
            for (int i = 0; i < 5; i++) {
                if ((bestMask & (1 << i)) != 0) {
                    stringBuilder.append("1 ");
                } else {
                    stringBuilder.append("0 ");
                }
            }
            return stringBuilder.toString().trim();
        }
    }

    static class Student {

        private final int availabilityMask;

        public Student(int availabilityMask) {
            this.availabilityMask = availabilityMask;
        }

        public boolean canAttend(int mask) {
            return (availabilityMask & mask) == mask;
        }
    }
}
