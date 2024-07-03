/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3363
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Coins {

    private static final int COIN_COUNT = 12;
    private static final int QUERY_COUNT = 3;
    private static final int COIN_PER_SIDE = 4;

    public static void main(String[] args) throws IOException {
        Query[] queries = parseQuery();

        System.out.print(solution(queries));
    }

    private static Query[] parseQuery() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Query[] queries = new Query[QUERY_COUNT];

        for (int i = 0; i < QUERY_COUNT; i++) {
            String str = bufferedReader.readLine();
            if (str == null || str.isEmpty()) {
                str = bufferedReader.readLine();
            }
            StringTokenizer stringTokenizer = new StringTokenizer(str);

            int[] left = new int[COIN_PER_SIDE];
            int[] right = new int[COIN_PER_SIDE];
            for (int c = 0; c < COIN_PER_SIDE; c++) {
                left[c] = Integer.parseInt(stringTokenizer.nextToken());
            }

            Sign sign = Sign.of(stringTokenizer.nextToken());

            for (int c = 0; c < COIN_PER_SIDE; c++) {
                right[c] = Integer.parseInt(stringTokenizer.nextToken());
            }

            queries[i] = new Query(left, right, sign);
        }

        return queries;
    }

    private static String solution(Query[] queries) {
        Weight[] coins = new Weight[COIN_COUNT + 1];
        Arrays.fill(coins, Weight.NORMAL);
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= COIN_COUNT; i++) {
            for (Weight weight : Weight.values()) {
                if (weight == Weight.NORMAL) {
                    continue;
                }
                coins[i] = weight;
                if (isCorrect(queries, coins)) {
                    result.add(i + coins[i].symbol);
                }
            }
            coins[i] = Weight.NORMAL;
        }

        if (result.isEmpty()) {
            return "impossible";
        }

        return result.size() == 1 ? result.get(0) : "indefinite";
    }

    private static boolean isCorrect(Query[] queries, Weight[] coins) {
        return Arrays.stream(queries)
                .allMatch(query -> query.isCorrect(coins));
    }

    enum Sign {
        LEFT(">"),
        RIGHT("<"),
        EQUAL("=");

        private final String symbol;

        Sign(String symbol) {
            this.symbol = symbol;
        }

        public static Sign of(String symbol) {
            return Arrays.stream(Sign.values())
                    .filter(sign -> sign.symbol.equals(symbol))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }

    enum Weight {
        HEAVY(1, "+"),
        LIGHT(-1, "-"),
        NORMAL(0, "");

        private final int value;
        private final String symbol;

        Weight(int value, String symbol) {
            this.value = value;
            this.symbol = symbol;
        }
    }

    static class Query {

        private final int[] left;
        private final int[] right;
        private final Sign sign;

        public Query(int[] left, int[] right, Sign sign) {
            this.left = left;
            this.right = right;
            this.sign = sign;
        }

        public boolean isCorrect(Weight[] coins) {
            int leftWeight = getLeftWeight(coins);
            int rightWeight = getRightWeight(coins);

            switch (sign) {
                case LEFT:
                    return leftWeight > rightWeight;
                case RIGHT:
                    return leftWeight < rightWeight;
                case EQUAL:
                    return leftWeight == rightWeight;
                default:
                    throw new IllegalArgumentException();
            }
        }

        private int getLeftWeight(Weight[] coins) {
            return Arrays.stream(left)
                    .map(c -> coins[c].value)
                    .sum();
        }

        private int getRightWeight(Weight[] coins) {
            return Arrays.stream(right)
                    .map(c -> coins[c].value)
                    .sum();
        }
    }
}
