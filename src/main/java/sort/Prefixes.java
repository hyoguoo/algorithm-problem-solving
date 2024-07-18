/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1141
 * Cheat Level: 3
 * Algorithm: Sort
 */

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Prefixes {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int wordCount = Integer.parseInt(bufferedReader.readLine());
        String[] words = new String[wordCount];

        for (int i = 0; i < wordCount; i++) {
            words[i] = bufferedReader.readLine();
        }

        System.out.print(solution(words));
    }

    private static int solution(String[] words) {
        Arrays.sort(words, (s1, s2) -> Integer.compare(s2.length(), s1.length()));

        Set<String> set = new HashSet<>();

        for (String word : words) {
            if (set.isEmpty()) {
                set.add(word);
                continue;
            }

            boolean isPrefix = false;

            for (String prefix : set) {
                if (prefix.startsWith(word)) {
                    isPrefix = true;
                    break;
                }
            }

            if (!isPrefix) {
                set.add(word);
            }
        }

        return set.size();
    }
}
