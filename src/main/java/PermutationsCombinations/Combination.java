/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2407
 * Cheat Level: 0
 * Algorithm: Combination / Big Integer
 */

package PermutationsCombinations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Combination {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(getCombination(input[0], input[1]));
    }

    private static BigInteger getCombination(int x, int y) {
        BigInteger bigInteger = BigInteger.ONE;
        for (int i = 0; i < y; i++) bigInteger = bigInteger.multiply(BigInteger.valueOf(x - i));
        for (int i = 1; i <= y; i++) bigInteger = bigInteger.divide(BigInteger.valueOf(i));

        return bigInteger;
    }
}
