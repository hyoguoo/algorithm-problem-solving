/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5635
 * Cheat Level: 0
 * Algorithm: Sort / Implementation
 */

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Birthday {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] info = bufferedReader.readLine().split(" ");
            students.add(new Student(info[0], Integer.parseInt(info[1]), Integer.parseInt(info[2]), Integer.parseInt(info[3])));
        }

        students.sort(Student::compareTo);

        System.out.println(students.get(students.size() - 1).name);
        System.out.println(students.get(0).name);
    }

    static class Student implements Comparable<Student> {
        String name;
        int birth;

        public Student(String name, int day, int month, int year) {
            this.name = name;
            this.birth = year * 10000 + month * 100 + day;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return birth == student.birth && Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, birth);
        }

        @Override
        public int compareTo(Student o) {
            return this.birth - o.birth;
        }
    }
}
