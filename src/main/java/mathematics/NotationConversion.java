/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2745
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NotationConversion {

    static final char ZERO = '0';
    static final char A = 'A';

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = bufferedReader.readLine().split(" ");

        System.out.print(solution(info[0], Integer.parseInt(info[1])));
    }

    private static int solution(String numberString, int base) {
        int result = 0;

        for (int i = 0; i < numberString.length(); i++) {
            char c = numberString.charAt(i);
            int value = Character.isDigit(c)
                    ? c - ZERO
                    : c - A + 10;
            result = result * base + value;
        }

        return result;
    }
}
