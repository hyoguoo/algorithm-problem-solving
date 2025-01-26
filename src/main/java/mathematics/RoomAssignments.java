/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 13300
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RoomAssignments {

    private static final int GRADE_COUNT = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int studentCount = info[0];
        int roomCapacity = info[1];
        Student[] students = new Student[studentCount];

        for (int i = 0; i < studentCount; i++) {
            int[] studentInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            students[i] = new Student(Gender.of(studentInfo[0]), studentInfo[1]);
        }

        System.out.print(solution(students, roomCapacity));
    }

    private static int solution(Student[] students, int roomCapacity) {
        int[] femaleCount = new int[GRADE_COUNT + 1];
        int[] maleCount = new int[GRADE_COUNT + 1];

        for (Student student : students) {
            switch (student.gender) {
                case MALE:
                    maleCount[student.grade]++;
                    break;
                case FEMALE:
                    femaleCount[student.grade]++;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }

        int maleRoomCount = calculateRoomCount(maleCount, roomCapacity);
        int femaleRoomCount = calculateRoomCount(femaleCount, roomCapacity);

        return maleRoomCount + femaleRoomCount;
    }

    private static int calculateRoomCount(int[] counts, int roomCapacity) {
        return Arrays.stream(counts)
                .map(count -> (int) Math.ceil((double) count / roomCapacity))
                .sum();
    }

    enum Gender {
        FEMALE(0),
        MALE(1);

        private final int value;

        Gender(int value) {
            this.value = value;
        }

        public static Gender of(int value) {
            return Arrays.stream(values())
                    .filter(gender -> gender.value == value)
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }

    static class Student {

        private final Gender gender;
        private final int grade;

        public Student(Gender gender, int grade) {
            this.gender = gender;
            this.grade = grade;
        }
    }
}
