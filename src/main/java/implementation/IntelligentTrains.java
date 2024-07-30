/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2455
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IntelligentTrains {

    private static final int QUERY_COUNT = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Train[] trains = new Train[QUERY_COUNT];
        for (int i = 0; i < QUERY_COUNT; i++) {
            int[] queryInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            trains[i] = new Train(queryInfo[0], queryInfo[1]);
        }

        System.out.print(solution(trains));
    }

    private static int solution(Train[] trains) {
        int max = 0;
        int current = 0;

        for (Train train : trains) {
            current -= train.in;
            current += train.out;
            max = Math.max(max, current);
        }

        return max;
    }

    static class Train {

        private final int in;
        private final int out;

        public Train(int in, int out) {
            this.in = in;
            this.out = out;
        }
    }
}
