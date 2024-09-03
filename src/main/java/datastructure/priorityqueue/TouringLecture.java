/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2109
 * Cheat Level: 0
 * Algorithm: Priority Queue / Greedy
 */

package datastructure.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;

public class TouringLecture {

    private static final int MAX_LECTURE_DAY = 10_000;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Lecture> priorityQueue = new PriorityQueue<>();

        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            priorityQueue.add(new Lecture(info[0], info[1]));
        }

        System.out.print(solution(priorityQueue));
    }

    private static int solution(PriorityQueue<Lecture> priorityQueue) {
        boolean[] isLectureDay = new boolean[MAX_LECTURE_DAY + 1];
        int totalPay = 0;

        while (!priorityQueue.isEmpty()) {
            Lecture lecture = priorityQueue.poll();
            for (int i = lecture.day; i > 0; i--) {
                if (!isLectureDay[i]) {
                    isLectureDay[i] = true;
                    totalPay += lecture.pay;
                    break;
                }
            }
        }

        return totalPay;
    }

    static class Lecture implements Comparable<Lecture> {

        private final int pay;
        private final int day;

        public Lecture(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Lecture lecture = (Lecture) o;
            return pay == lecture.pay && day == lecture.day;
        }

        @Override
        public int hashCode() {
            return Objects.hash(pay, day);
        }

        @Override
        public int compareTo(Lecture o) {
            if (this.pay == o.pay) {
                return this.day - o.day;
            }
            return o.pay - this.pay;
        }
    }
}

