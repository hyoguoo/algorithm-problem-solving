/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 27375
 * Cheat Level: 0
 * Algorithm: Brute Force / Backtracking
 */

package bruteforce.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KeepFridayFree {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int lessonCount = info[0];
        int targetGrade = info[1];
        Lesson[] lessons = new Lesson[lessonCount];

        for (int i = 0; i < lessonCount; i++) {
            int[] lessonInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            lessons[i] = new Lesson(Day.valueOf(lessonInfo[0]), lessonInfo[1], lessonInfo[2]);
        }

        System.out.print(solution(lessons, targetGrade));
    }

    private static int solution(Lesson[] lessons, int targetGrade) {
        FridayFreeSimulate fridayFreeSimulate = new FridayFreeSimulate(lessons, targetGrade);
        return fridayFreeSimulate.simulate();
    }

    enum Day {
        MONDAY(1),
        TUESDAY(2),
        WEDNESDAY(3),
        THURSDAY(4),
        FRIDAY(5);

        private final int value;

        Day(int value) {
            this.value = value;
        }

        public static Day valueOf(int value) {
            return Arrays.stream(values())
                    .filter(day -> day.value == value)
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }

    static class FridayFreeSimulate {

        private static final int TIME_TABLE_SIZE = 10;
        private final Lesson[] lessons;
        private final boolean[][] timetable;
        private final int targetGrade;
        private int count;

        public FridayFreeSimulate(Lesson[] lessons, int targetGrade) {
            this.lessons = lessons;
            this.targetGrade = targetGrade;
            timetable = new boolean[Day.values().length + 1][TIME_TABLE_SIZE + 1];
            this.count = 0;
        }

        public int simulate() {
            selectLessonRecursively(0, 0);
            return this.count;
        }

        private void selectLessonRecursively(int index, int grade) {
            if (index == lessons.length) {
                if (grade == targetGrade) {
                    count++;
                }
                return;
            }

            if (grade > targetGrade) {
                return;
            }

            if (lessons[index].day != Day.FRIDAY && isEnableToSelectLesson(lessons[index])) {
                selectLesson(lessons[index]);
                selectLessonRecursively(index + 1, grade + lessons[index].grade);
                deselectLesson(lessons[index]);
            }

            selectLessonRecursively(index + 1, grade);
        }

        private boolean isEnableToSelectLesson(Lesson lesson) {
            for (int i = lesson.start; i <= lesson.end; i++) {
                if (timetable[lesson.day.value][i]) {
                    return false;
                }
            }

            return true;
        }

        private void selectLesson(Lesson lesson) {
            for (int i = lesson.start; i <= lesson.end; i++) {
                timetable[lesson.day.value][i] = true;
            }
        }

        private void deselectLesson(Lesson lesson) {
            for (int i = lesson.start; i <= lesson.end; i++) {
                timetable[lesson.day.value][i] = false;
            }
        }
    }

    static class Lesson {

        private final Day day;
        private final int start;
        private final int end;
        private final int grade;

        public Lesson(Day day, int start, int end) {
            this.day = day;
            this.start = start;
            this.end = end;
            this.grade = end - start + 1;
        }
    }
}
