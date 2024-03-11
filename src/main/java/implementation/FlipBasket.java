/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10811
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FlipBasket {

    static final BufferedReader BUFFERED_READER =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] info = Arrays.stream(BUFFERED_READER.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(
                solution(
                        parseBaskets(info[0]),
                        parseFlipQueries(info[1])
                )
        );
    }

    private static String solution(int[] baskets, FlipQuery[] flipQueries) {
        for (FlipQuery flipQuery : flipQueries) {
            flip(baskets, flipQuery.start, flipQuery.end);
        }

        return Arrays.toString(Arrays.copyOfRange(baskets, 1, baskets.length))
                .replaceAll("[\\[\\],]", "");
    }

    private static void flip(int[] baskets, int start, int end) {
        int[] temp = new int[end - start + 1];
        System.arraycopy(baskets, start, temp, 0, temp.length);
        for (int i = 0; i < temp.length; i++) {
            baskets[start + i] = temp[temp.length - 1 - i];
        }
    }

    private static int[] parseBaskets(int basketCount) {
        int[] baskets = new int[basketCount + 1];
        for (int i = 1; i <= basketCount; i++) {
            baskets[i] = i;
        }
        return baskets;
    }

    private static FlipQuery[] parseFlipQueries(int flipCount) throws IOException {
        FlipQuery[] flipQueries = new FlipQuery[flipCount];
        for (int i = 0; i < flipCount; i++) {
            int[] flipInfo = Arrays.stream(BUFFERED_READER.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            flipQueries[i] = new FlipQuery(flipInfo[0], flipInfo[1]);
        }
        return flipQueries;
    }

    static class FlipQuery {

        int start;
        int end;

        public FlipQuery(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
