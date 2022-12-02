/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1152
 */

package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOfWords {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        System.out.println(getNumberOfWords(input));
    }

    private static int getNumberOfWords(String input) {
        String[] str = input.split(" ");
        int count = 0;
        for (String s : str) {
            if (!s.equals("")) count++;
        }
        return count;
    }
}
