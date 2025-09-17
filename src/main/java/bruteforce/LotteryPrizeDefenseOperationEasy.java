/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 20410
 * Cheat Level: 0
 * Algorithm: Bruteforce
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LotteryPrizeDefenseOperationEasy {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int m = info[0];
        int seed = info[1];
        int x1 = info[2];
        int x2 = info[3];

        System.out.print(solution(m, seed, x1, x2));
    }

    private static Result solution(int m, int seed, int x1, int x2) {
        return IntStream.range(0, m)
                .boxed()
                .flatMap(a -> generateResults(a, m))
                .filter(result -> isValid(result, m, seed, x1, x2))
                .findFirst()
                .orElseThrow();
    }

    private static Stream<Result> generateResults(int a, int m) {
        return IntStream.range(0, m)
                .mapToObj(c -> new Result(a, c));
    }

    private static boolean isValid(Result result, int m, int seed, int x1, int x2) {
        return (result.a * seed + result.c) % m == x1 &&
                (result.a * x1 + result.c) % m == x2;
    }


    static class Result {

        private final int a;
        private final int c;

        public Result(int a, int c) {
            this.a = a;
            this.c = c;
        }

        @Override
        public String toString() {
            return a + " " + c;
        }
    }
}
