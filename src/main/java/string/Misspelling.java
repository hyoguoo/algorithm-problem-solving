/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2711
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Misspelling {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int wordCount = Integer.parseInt(bufferedReader.readLine());

        Query[] queries = new Query[wordCount];

        for (int i = 0; i < wordCount; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int deleteIndex = Integer.parseInt(input[0]);
            String word = input[1];
            queries[i] = new Query(deleteIndex, word);
        }

        System.out.print(solution(queries));
    }

    private static String solution(Query[] queries) {
        return Arrays.stream(queries)
                .map(Query::delete)
                .collect(Collectors.joining("\n"));
    }

    static class Query  {
        private final int deleteIndex;
        private final String word;

        public Query(int deleteIndex, String word) {
            this.deleteIndex = deleteIndex;
            this.word = word;
        }

        public String delete() {
            return new StringBuilder(word)
                    .deleteCharAt(deleteIndex - 1)
                    .toString();
        }
    }
}
