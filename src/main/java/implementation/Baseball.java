/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10214
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baseball {

    private static final int ROUND_COUNT = 9;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            Query[] queries = new Query[ROUND_COUNT];
            for (int i = 0; i < ROUND_COUNT; i++) {
                int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                queries[i] = new Query(info[0], info[1]);
            }

            stringBuilder.append(solution(queries)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static String solution(Query[] queries) {
        int yonseiScore = 0;
        int koreaScore = 0;

        for (Query query : queries) {
            yonseiScore += query.yonseiScore;
            koreaScore += query.koreaScore;
        }

        switch (Integer.compare(yonseiScore, koreaScore)) {
            case 1:
                return Result.YONSEI.value;
            case -1:
                return Result.KOREA.value;
            case 0:
                return Result.DRAW.value;
            default:
                throw new IllegalArgumentException();
        }
    }

    enum Result {
        YONSEI("Yonsei"),
        KOREA("Korea"),
        DRAW("Draw");

        private final String value;

        Result(String value) {
            this.value = value;
        }
    }

    static class Query {

        private final int yonseiScore;
        private final int koreaScore;

        public Query(int yonseiScore, int koreaScore) {
            this.yonseiScore = yonseiScore;
            this.koreaScore = koreaScore;
        }
    }
}
