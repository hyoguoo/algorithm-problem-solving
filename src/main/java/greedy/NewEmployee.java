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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NewEmployee {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(bufferedReader.readLine());
        for (int count = 0; count < caseCount; count++) {
            int employeeCount = Integer.parseInt(bufferedReader.readLine());
            List<Employee> employees = new ArrayList<>();
            for (int i = 0; i < employeeCount; i++) {
                int[] employeeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                employees.add(new Employee(employeeInfo[0], employeeInfo[1]));
            }
            System.out.println(solution(employees));
        }
    }

    private static int solution(List<Employee> employees) {
        employees.sort(Comparator.comparingInt(o -> o.document));
        int notHiredCount = 0;
        int interviewLowerBound = employees.get(0).interview;

        for (Employee employee : employees) {
            if (employee.interview > interviewLowerBound) notHiredCount++;
            else interviewLowerBound = employee.interview;
        }

        return employees.size() - notHiredCount;
    }

    static class Employee {
        int document;
        int interview;

        public Employee(int document, int interview) {
            this.document = document;
            this.interview = interview;
        }
    }
}
