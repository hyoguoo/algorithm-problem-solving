/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1212
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OctalBinary {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(solution(bufferedReader.readLine()));
    }

    private static String solution(String octal) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = octal.length();
        for (int i = 0; i < length; i++) {
            int number = octal.charAt(i) - '0';
            stringBuilder.append((number & 4) > 0 ? 1 : 0)
                    .append((number & 2) > 0 ? 1 : 0)
                    .append((number & 1) > 0 ? 1 : 0);
        }
        return stringBuilder.toString().replaceFirst("^0+(?!$)", "");
    }
}
