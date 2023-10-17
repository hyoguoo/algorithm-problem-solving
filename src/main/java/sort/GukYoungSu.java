/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10825
 * Cheat Level: 0
 * Algorithm: Sort
 */

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GukYoungSu {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());
        Student[] students = new Student[count];

        for (int i = 0; i < count; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            students[i] = new Student(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3]));
        }

        Arrays.sort(students);
        printStudentName(students);
    }

    private static void printStudentName(Student[] students) {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(students).forEach(student -> stringBuilder.append(student.name).append("\n"));
        System.out.println(stringBuilder);
    }

    static class Student implements Comparable<Student> {
        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if (o.korean != this.korean) return o.korean - this.korean;
            else if (o.english != this.english) return this.english - o.english;
            else if (o.math != this.math) return o.math - this.math;
            else return this.name.compareTo(o.name);
        }
    }
}
