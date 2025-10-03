/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 20126
 * Cheat Level: 0
 * Algorithm: Sort
 */

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProfessorsFinalExam {

    private static final int IMPOSSIBLE = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int examCount = info[0];
        int examDuration = info[1];
        int limitTime = info[2];

        ExamTime[] examTimes = new ExamTime[examCount];

        for (int i = 0; i < examCount; i++) {
            int[] examInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            examTimes[i] = new ExamTime(examInfo[0], examInfo[1]);
        }

        System.out.print(solution(examTimes, examDuration, limitTime));
    }

    private static int solution(ExamTime[] examTimes, int examDuration, int limitTime) {
        ExamTime[] sortedExamTimes = Arrays.stream(examTimes)
                .sorted((e1, e2) -> {
                    if (e1.startTime == e2.startTime) {
                        return Integer.compare(e2.duration, e1.duration);
                    }
                    return Integer.compare(e1.startTime, e2.startTime);
                })
                .toArray(ExamTime[]::new);

        if (sortedExamTimes[0].startTime >= examDuration) {
            return 0;
        }

        for (int i = 0; i < sortedExamTimes.length - 1; i++) {
            ExamTime currentExam = sortedExamTimes[i];
            ExamTime nextExam = sortedExamTimes[i + 1];

            if (currentExam.getEndTime() + examDuration <= nextExam.startTime) {
                return currentExam.getEndTime();
            }
        }

        if (sortedExamTimes[sortedExamTimes.length - 1].getEndTime() + examDuration <= limitTime) {
            return sortedExamTimes[sortedExamTimes.length - 1].getEndTime();
        }

        return IMPOSSIBLE;
    }

    static class ExamTime {

        private final int startTime;
        private final int duration;

        public ExamTime(int startTime, int duration) {
            this.startTime = startTime;
            this.duration = duration;
        }

        public int getEndTime() {
            return startTime + duration;
        }
    }
}
