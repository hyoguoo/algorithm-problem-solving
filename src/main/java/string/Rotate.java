/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 23813
 * Cheat Level: 0
 * Algorithm: String / Implementation
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Rotate {

    public static void main(String[] args) throws IOException {
        System.out.print(solution(new BufferedReader(new InputStreamReader(System.in)).readLine()));
    }

    private static BigInteger solution(String input) {
        StringBuilder currentString = new StringBuilder(input);
        BigInteger result = new BigInteger(input);

        for (int i = 0; i < input.length() - 1; i++) {
            currentString.append(currentString.charAt(0)).deleteCharAt(0);
            result = result.add(new BigInteger(currentString.toString()));
        }

        return result;
    }
}
