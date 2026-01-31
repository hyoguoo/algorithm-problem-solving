/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 22233
 * Cheat Level: 0
 * Algorithm: Data Structure / Set
 */

package datastructure.mapset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GaheeAndKeyword {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int keywordCount = info[0];
        int postCount = info[1];
        String[] keywords = new String[keywordCount];
        for (int i = 0; i < keywordCount; i++) {
            keywords[i] = bufferedReader.readLine();
        }

        String[][] postKeywords = new String[postCount][];
        for (int i = 0; i < postCount; i++) {
            postKeywords[i] = bufferedReader.readLine().split(",");
        }

        System.out.print(solution(postKeywords, keywords));
    }

    private static String solution(String[][] postKeywords, String[] keywords) {
        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywords));
        List<Integer> remainingKeywordCountList = new ArrayList<>();

        Arrays.stream(postKeywords)
                .forEach(postKeyword -> {
                    Arrays.stream(postKeyword)
                            .forEach(keywordSet::remove);
                    remainingKeywordCountList.add(keywordSet.size());
                });

        return remainingKeywordCountList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
