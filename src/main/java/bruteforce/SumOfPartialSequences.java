/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1182
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumOfPartialSequences {

    static int[] numbers;
    static int count = 0;
    static int target;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        target = info[1];
        numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        solution();
        System.out.println(target == 0 ? count - 1 : count);
    }

    private static void solution() {
        recursion(0, 0);
    }

    private static void recursion(int sum, int index) {
        if (index == numbers.length) {
            if (sum == target) count++;
            return;
        }
        recursion(sum + numbers[index], index + 1);
        recursion(sum, index + 1);
    }
}
