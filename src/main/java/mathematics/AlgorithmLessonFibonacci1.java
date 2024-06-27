/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 24416
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlgorithmLessonFibonacci1 {

    private static int recursionCount = 0;
    private static int dpCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        System.out.print(solution(n));
    }

    private static String solution(int n) {
        fibonacciRecursion(n);
        fibonacciDp(n);

        return recursionCount + " " + dpCount;
    }

    private static int fibonacciRecursion(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            recursionCount++;
            return 1;
        } else {
            return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
        }
    }

    private static void fibonacciDp(int n) {
        for (int i = 3; i <= n; i++) {
            dpCount++;
        }
    }
}
