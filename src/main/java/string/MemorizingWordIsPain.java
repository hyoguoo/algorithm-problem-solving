/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 20920
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MemorizingWordIsPain {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int wordCount = info[0];
        int minLength = info[1];

        Map<String, Integer> wordMap = new HashMap<>();

        while (wordCount-- > 0) {
            String word = bufferedReader.readLine();
            if (word.length() < minLength) {
                continue;
            }
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        System.out.print(solution(wordMap));
    }

    private static String solution(Map<String, Integer> wordMap) {
        StringBuilder stringBuilder = new StringBuilder();

        wordMap.entrySet().stream()
                .sorted((o1, o2) -> {
                    if (o1.getValue().equals(o2.getValue())) {
                        if (o1.getKey().length() == o2.getKey().length()) {
                            return o1.getKey().compareTo(o2.getKey());
                        }
                        return o2.getKey().length() - o1.getKey().length();
                    }
                    return o2.getValue() - o1.getValue();
                })
                .forEach(e -> stringBuilder.append(e.getKey()).append("\n"));

        return stringBuilder.toString().trim();
    }
}
