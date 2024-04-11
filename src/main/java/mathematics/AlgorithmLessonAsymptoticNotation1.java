/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 24313
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AlgorithmLessonAsymptoticNotation1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int a1 = info[0];
        int a0 = info[1];
        int c = Integer.parseInt(bufferedReader.readLine());
        int n0 = Integer.parseInt(bufferedReader.readLine());

        System.out.print(solution(a1, a0, c, n0) ? 1 : 0);
    }

    private static boolean solution(int a1, int a0, int c, int n0) {
        return a1 * n0 + a0 <= c * n0 && c >= a1;
    }
}
