/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10808
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AlphabetCount {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        char[] input = bufferedReader.readLine().toCharArray();
        int[] count = new int[26];

        for (char c : input) count[c - 97]++;

        System.out.println(String.join(" ", Arrays.stream(count).mapToObj(String::valueOf).toArray(String[]::new)));
    }
}
