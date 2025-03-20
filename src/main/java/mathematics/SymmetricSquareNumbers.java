/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 33573
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SymmetricSquareNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            stringBuilder
                    .append(solution(Long.parseLong(bufferedReader.readLine())) ? "YES" : "NO")
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static boolean solution(long n) {
        long reversedN = Long.parseLong(new StringBuilder(String.valueOf(n)).reverse().toString());
        return isSquareNumber(n) && isSquareNumber(reversedN);
    }

    private static boolean isSquareNumber(long n) {
        long sqrt = (long) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}
