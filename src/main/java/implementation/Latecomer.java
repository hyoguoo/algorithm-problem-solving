/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 32280
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Latecomer {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int studentCount = Integer.parseInt(bufferedReader.readLine());

        List<Person> people = new ArrayList<>();
        for (int i = 0; i < studentCount + 1; i++) {
            String[] info = bufferedReader.readLine().split(" ");
            String time = info[0];
            String type = info[1];
            people.add(new Person(timeToMinutes(time), type));
        }

        String schoolTime = bufferedReader.readLine();
        int schoolTimeMinutes = timeToMinutes(schoolTime);

        System.out.println(solution(people, schoolTimeMinutes));
    }

    private static int solution(List<Person> people, int schoolTimeMinutes) {
        int teacherArrivalTime = -1;

        for (Person person : people) {
            if (person.type.equals("teacher")) {
                teacherArrivalTime = person.arrivalTime;
                break;
            }
        }

        int cleanupCount = 0;
        for (Person person : people) {
            if (person.type.equals("student")) {
                boolean isLate = person.arrivalTime >= schoolTimeMinutes;
                boolean caughtByTeacher = person.arrivalTime >= teacherArrivalTime;

                if (isLate && caughtByTeacher) {
                    cleanupCount++;
                }
            }
        }

        return cleanupCount;
    }

    private static int timeToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }

    static class Person {

        private final int arrivalTime;
        private final String type;

        public Person(int arrivalTime, String type) {
            this.arrivalTime = arrivalTime;
            this.type = type;
        }
    }
}
