/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11656
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SuffixArray {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        String[] suffixArray = getSuffixArray(input);

        Arrays.sort(suffixArray);
        System.out.println(getResult(suffixArray));
    }

    private static String getResult(String[] suffixArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String suffix : suffixArray) stringBuilder.append(suffix).append("\n");
        return stringBuilder.toString();
    }

    private static String[] getSuffixArray(String input) {
        String[] suffixArray = new String[input.length()];
        for (int i = 0; i < input.length(); i++) suffixArray[i] = input.substring(i);
        return suffixArray;
    }
}
