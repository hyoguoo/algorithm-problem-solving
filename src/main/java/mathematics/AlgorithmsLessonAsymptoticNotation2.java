/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 24314
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AlgorithmsLessonAsymptoticNotation2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int coefficientN = info[0];
        int constantTerm = info[1];
        int omegaConstant = Integer.parseInt(bufferedReader.readLine());
        int thresholdN0 = Integer.parseInt(bufferedReader.readLine());

        System.out.print(
                solution(coefficientN, constantTerm, omegaConstant, thresholdN0)
                        ? 1
                        : 0
        );
    }

    private static boolean solution(int coefficientN, int constantTerm, int omegaConstant, int thresholdN0) {
        return (omegaConstant * thresholdN0 <= coefficientN * thresholdN0 + constantTerm) &&
                (coefficientN >= omegaConstant);
    }
}
