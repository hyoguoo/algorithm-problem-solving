/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1946
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class NewEmployee {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            int employeeCount = Integer.parseInt(bufferedReader.readLine());
            Employee[] employees = new Employee[employeeCount];
            for (int i = 0; i < employeeCount; i++) {
                int[] employeeInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                employees[i] = (new Employee(employeeInfo[0], employeeInfo[1]));
            }
            stringBuilder.append(solution(employees)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(Employee[] employees) {
        Arrays.sort(employees, Comparator.comparingInt(o -> o.document));
        int notHiredCount = 0;
        int interviewLowerBound = employees[0].interview;

        for (Employee employee : employees) {
            if (employee.isHigherInterviewScore(interviewLowerBound)) {
                notHiredCount++;
            } else {
                interviewLowerBound = employee.interview;
            }
        }

        return employees.length - notHiredCount;
    }

    static class Employee {

        private final int document;
        private final int interview;

        public Employee(int document, int interview) {
            this.document = document;
            this.interview = interview;
        }

        public boolean isHigherInterviewScore(int interviewScore) {
            return this.interview > interviewScore;
        }
    }
}
