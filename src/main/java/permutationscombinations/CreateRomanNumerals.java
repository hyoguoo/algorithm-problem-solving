/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16922
 * Cheat Level: 0
 * Algorithm: Combinations
 */

package permutationscombinations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class CreateRomanNumerals {

    private static final int[] ROMAN_NUMERALS = {1, 5, 10, 50};

    public static void main(String[] args) throws IOException {
        System.out.print(
                solution(
                        Integer.parseInt(
                                new BufferedReader(new InputStreamReader(System.in)).readLine()
                        )
                )
        );
    }

    private static int solution(int n) {
        Set<Integer> set = new HashSet<>();
        recursion(set, 0, 0, n, 0);
        return set.size();
    }

    private static void recursion(Set<Integer> set, int currentValue, int depth, int n, int index) {
        if (depth == n) {
            set.add(currentValue);
            return;
        }

        for (int i = index; i < ROMAN_NUMERALS.length; i++) {
            int romanNumeral = ROMAN_NUMERALS[i];
            recursion(set, currentValue + romanNumeral, depth + 1, n, i);
        }
    }
}
