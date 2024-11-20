/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1547
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ball {

    private static final int INITIAL_BALL_POSITION = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int changeCount = Integer.parseInt(bufferedReader.readLine());

        Query[] queries = new Query[changeCount];

        for (int i = 0; i < changeCount; i++) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            queries[i] = new Query(info[0], info[1]);
        }

        System.out.print(solution(queries));
    }

    private static int solution(Query[] queries) {
        int ballPosition = INITIAL_BALL_POSITION;

        for (Query query : queries) {
            if (query.from == ballPosition) {
                ballPosition = query.to;
            } else if (query.to == ballPosition) {
                ballPosition = query.from;
            }
        }

        return ballPosition;
    }

    static class Query {

        private final int from;
        private final int to;

        public Query(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
}
