/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5717
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FirendOfSangguen {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int a = input[0];
            int b = input[1];

            if (a == 0 && b == 0) {
                break;
            }

            stringBuilder.append(solution(a, b)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int a, int b) {
        return a + b;
    }
}
