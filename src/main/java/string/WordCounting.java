/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 19844
 * Cheat Level: 2
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounting {

    private static final String REGEX = "^(c|j|n|m|t|s|l|d|qu)(')[aeiouh]";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(solution(bufferedReader.readLine()));
    }

    private static int solution(String s) {
        String[] words = s.split("[\\s-]");
        int count = words.length;

        for (String word : words) {
            Matcher matcher = Pattern.compile(REGEX).matcher(word);
            while (matcher.find()) {
                count++;
            }
        }

        return count;
    }
}
