/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 28018
 * Cheat Level: 0
 * Algorithm: Prefix Sum / Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TimeOverlap {

    private static final int MAX_TIME = 1_000_000;

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
        bufferedReader.readLine();
        int[] times = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(students, times));
    }

    private static String solution(Student[] students, int[] times) {
        int[] prefixSum = new int[MAX_TIME + 2];

        for (Student student : students) {
            prefixSum[student.startTime]++;
            prefixSum[student.endTime + 1]--;
        }

        for (int i = 1; i <= MAX_TIME; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }

        return resultToString(times, prefixSum);
    }

    private static String resultToString(int[] times, int[] prefixSum) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int time : times) {
            stringBuilder.append(prefixSum[time]).append("\n");
        }

        return stringBuilder.toString().trim();
    }

    static class Student {

        private final int startTime;
        private final int endTime;

        public Student(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
