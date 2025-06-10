/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1284
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HouseNumbers {

    private static final String END_SIGN = "0";
    private static final int[] NUMBER_LENGTHS = {4, 2, 3, 3, 3, 3, 3, 3, 3, 3};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            String houseNumber = bufferedReader.readLine();

            if (houseNumber.equals(END_SIGN)) {
                break;
            }

            stringBuilder.append(solution(houseNumber)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(String houseNumber) {
        return Arrays.stream(houseNumber.split(""))
                .mapToInt(Integer::parseInt)
                .map(digit -> NUMBER_LENGTHS[digit] + 1)
                .sum() + 1;
    }
}
