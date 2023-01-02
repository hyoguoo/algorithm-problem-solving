/*
 * goormlevel
 * https://level.goorm.io
 * Monday Challenge: 1주차 문제 3
 * Cheat Level: 0
 * Algorithm: Sort
 */

package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AttendanceBook {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int length = array[0];
        int orderNumber = array[1];
        List<AttendanceBookStudent> students = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            String[] inputString = bufferedReader.readLine().split(" ");
            String name = inputString[0];
            double height = Double.parseDouble(inputString[1]);
            students.add(new AttendanceBookStudent(name, height));
        }
        Collections.sort(students);
        AttendanceBookStudent student = students.get(orderNumber - 1);
        System.out.printf("%s %.2f", student.getName(), student.getHeight());
    }
}

class AttendanceBookStudent implements Comparable<AttendanceBookStudent> {

    private final String name;
    private final double height;

    public AttendanceBookStudent(String name, double height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public int compareTo(AttendanceBookStudent o) {
        if (this.getName().compareTo(o.getName()) > 0) {
            return 1;
        } else if (this.getName().compareTo(o.getName()) < 0) {
            return -1;
        } else {
            if (this.getHeight() - o.getHeight() > 0) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
