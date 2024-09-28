/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1181
 * Cheat Level: 0
 * Algorithm: Sort
 */

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class WordSort {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int wordCount = Integer.parseInt(bufferedReader.readLine());

        String[] words = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            words[i] = bufferedReader.readLine();
        }

        System.out.print(solution(words));
    }

    private static String solution(String[] words) {
        return Arrays.stream(words)
                .distinct()
                .sorted(getWordComparator())
                .collect(Collectors.joining("\n"));
    }

    private static Comparator<String> getWordComparator() {
        return (o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            } else {
                return o1.compareTo(o2);
            }
        };
    }
}
