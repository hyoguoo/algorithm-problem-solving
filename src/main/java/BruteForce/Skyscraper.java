/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1027
 * Cheat Level: 2
 * Algorithm: Brute Force / Mathematics
 */

package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Skyscraper {

    static double[] building;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        building = Arrays.stream(bufferedReader.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        System.out.println(solution());
    }

    private static int solution() {
        int answer = 0;

        for (int i = 0; i < building.length; i++) {
            answer = Math.max(answer, solve(i));
        }

        return answer;
    }

    public static int solve(int current) {
        Stack<Double> stack = new Stack<>();

        for (int target = current - 1; target >= 0; target--) {
            double slope = (building[target] - building[current]) / (current - target);
            if (target == current - 1 || stack.peek() < slope) {
                stack.push(slope);
            }
        }

        for (int target = current + 1; target < building.length; target++) {
            double slope = (building[target] - building[current]) / (target - current);
            if (target == current + 1 || stack.peek() < slope) {
                stack.push(slope);
            }
        }
        return stack.size();
    }
}
