/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1225
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CowMultiplication {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbersString = bufferedReader.readLine().split(" ");

        System.out.print(solution(numbersString[0], numbersString[1]));
    }

    private static long solution(String numberString1, String numberString2) {
        return numberString1.codePoints()
                .mapToLong(c1 -> c1 - '0')
                .flatMap(n1 -> numberString2.codePoints()
                        .mapToLong(c2 -> n1 * (c2 - '0')))
                .sum();
    }
}
