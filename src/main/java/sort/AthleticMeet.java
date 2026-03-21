/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 23056
 * Cheat Level: 0
 * Algorithm: Sort / Implementation
 */

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AthleticMeet {

    private static final String END_SIGN = "0 0";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        List<StudentRequest> studentRequests = new ArrayList<>();
        while (true) {
            String input = bufferedReader.readLine();
            if (input == null || input.equals(END_SIGN)) {
                break;
            }
            String[] info = input.split(" ");
            int classNo = Integer.parseInt(info[0]);
            String name = info[1];
            studentRequests.add(new StudentRequest(classNo, name));
        }

        System.out.print(solution(n, m, studentRequests));
    }

    private static String solution(int n, int m, List<StudentRequest> studentRequests) {
        Map<Integer, Integer> classCountMap = new HashMap<>();
        List<Student> acceptedStudents = new ArrayList<>();

        for (StudentRequest request : studentRequests) {
            int classNo = request.getClassNo();
            int currentCount = classCountMap.getOrDefault(classNo, 0);

            if (currentCount < m) {
                acceptedStudents.add(new Student(classNo, request.getName()));
                classCountMap.put(classNo, currentCount + 1);
            }
        }

        Collections.sort(acceptedStudents);

        return acceptedStudents.stream()
                .map(Student::toString)
                .collect(Collectors.joining("\n"));
    }

    enum Team {
        BLUE, WHITE;

        public static Team of(int classNo) {
            return classNo % 2 != 0 ? BLUE : WHITE;
        }
    }

    static class StudentRequest {

        private final int classNo;
        private final String name;

        public StudentRequest(int classNo, String name) {
            this.classNo = classNo;
            this.name = name;
        }

        public int getClassNo() {
            return classNo;
        }

        public String getName() {
            return name;
        }
    }

    static class Student implements Comparable<Student> {

        private final int classNo;
        private final String name;
        private final Team team;

        public Student(int classNo, String name) {
            this.classNo = classNo;
            this.name = name;
            this.team = Team.of(classNo);
        }

        @Override
        public int compareTo(Student o) {
            if (this.team != o.team) {
                return this.team.compareTo(o.team);
            }
            if (this.classNo != o.classNo) {
                return Integer.compare(this.classNo, o.classNo);
            }
            if (this.name.length() != o.name.length()) {
                return Integer.compare(this.name.length(), o.name.length());
            }
            return this.name.compareTo(o.name);
        }

        @Override
        public String toString() {
            return classNo + " " + name;
        }
    }
}
