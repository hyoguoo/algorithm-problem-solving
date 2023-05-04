/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15829
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hashing {

    static final int M = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();

        System.out.println(getHashing(bufferedReader.readLine()));
    }

    private static long getHashing(String input) {
        long sum = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            long number = c - 'a' + 1;

            sum += pow(number, i);
            sum %= M;
        }

        return sum;
    }

    private static long pow(long number, int i) {
        long result = 1;

        for (int j = 0; j < i; j++) result = (result * 31) % M;

        return (result * number) % M;
    }
}
