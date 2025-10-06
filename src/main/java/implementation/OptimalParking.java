/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5054
 * Cheat Level: 0
 * Algorithm: Implementation / Mathematics
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class OptimalParking {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            bufferedReader.readLine();
            int[] storePositions = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            stringBuilder
                    .append(solution(storePositions))
                    .append(System.lineSeparator());
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int[] storePositions) {
        int minPosition = Arrays.stream(storePositions).min().orElse(0);
        int maxPosition = Arrays.stream(storePositions).max().orElse(0);

        return (maxPosition - minPosition) * 2;
    }
}
