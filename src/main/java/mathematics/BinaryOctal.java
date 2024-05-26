/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1373
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryOctal {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(solution(bufferedReader.readLine()));
    }

    private static String solution(String binary) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = binary.length();
        int remainder = length % 3;
        if (remainder != 0) {
            stringBuilder.append(Integer.parseInt(binary.substring(0, remainder), 2));
        }
        for (int i = remainder; i < length; i += 3) {
            stringBuilder.append(Integer.parseInt(binary.substring(i, i + 3), 2));
        }
        return stringBuilder.toString();
    }
}
