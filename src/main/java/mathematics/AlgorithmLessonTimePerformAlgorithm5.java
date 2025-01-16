/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 24265
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlgorithmLessonTimePerformAlgorithm5 {

    public static void main(String[] args) throws IOException {
        System.out.print(solution(Long.parseLong(new BufferedReader(new InputStreamReader(System.in)).readLine())));
    }

    private static String solution(long n) {
        return n * n * n + "\n" + 3;
    }
}
