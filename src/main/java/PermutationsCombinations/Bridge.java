/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1010
 * Cheat Level: 0
 * Algorithm: Combination
 */

package PermutationsCombinations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bridge {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < length; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            System.out.println(combination(N, M));
        }
    }

    private static int combination(int N, int M) {
        long result = 1;

        for (int i = 0; i < N; i++) {
            result *= M - i;
            result /= i + 1;
        }
        return (int) result;
    }
}
