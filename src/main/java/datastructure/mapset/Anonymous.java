/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1764
 * Cheat Level: 0
 * Algorithm: Map
 */

package datastructure.mapset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Anonymous {

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = info[0];
        int m = info[1];

        solution(n, m);
    }

    private static void solution(int n, int m) throws IOException {
        Set<String> wordSet = getWordSet(n);
        List<String> duplicateList = getDuplicateList(m, wordSet);

        printResult(duplicateList);
    }

    private static void printResult(List<String> duplicateList) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(duplicateList.size()).append("\n");
        for (String word : duplicateList) {
            stringBuilder.append(word).append("\n");
        }

        System.out.print(stringBuilder);
    }

    private static List<String> getDuplicateList(int m, Set<String> wordSet) throws IOException {
        List<String> duplicateList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String str = bufferedReader.readLine();
            if (wordSet.contains(str)) duplicateList.add(str);
        }

        Collections.sort(duplicateList);
        return duplicateList;
    }

    private static Set<String> getWordSet(int n) throws IOException {
        Set<String> wordSet = new HashSet<>();

        for (int i = 0; i < n; i++) wordSet.add(bufferedReader.readLine());

        return wordSet;
    }
}
