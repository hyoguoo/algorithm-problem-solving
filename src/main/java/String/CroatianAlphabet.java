/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2941
 * Cheat Level: 0
 * Algorithm: String
 */

package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CroatianAlphabet {

    static final String[] croatianAlphabets = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        System.out.println(countCroAlphabet(input));
    }

    private static int countCroAlphabet(String input) {
        for (String croatianAlphabet : croatianAlphabets) {
            if (input.contains(croatianAlphabet)) input = input.replace(croatianAlphabet, " ");
        }
        return input.length();
    }
}
