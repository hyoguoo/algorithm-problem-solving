/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 34691
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DoYouLoveDSHS {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<SymbolQuery> symbolQueryList = new ArrayList<>();

        while (true) {
            String input = bufferedReader.readLine();
            if (input == null || input.equals("end")) {
                break;
            }
            symbolQueryList.add(new SymbolQuery(input));
        }

        Queries queries = new Queries(symbolQueryList);

        System.out.println(solution(queries));
    }

    private static String solution(Queries queries) {
        return queries.symbolQueries.stream()
                .map(symbolQuery -> symbolQuery.symbol.scientificName)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    enum Symbol {
        ANIMAL("animal", "Panthera tigris"),
        TREE("tree", "Pinus densiflora"),
        FLOWER("flower", "Forsythia koreana");

        private final String keyword;
        private final String scientificName;

        Symbol(String keyword, String scientificName) {
            this.keyword = keyword;
            this.scientificName = scientificName;
        }

        public static Symbol of(String keyword) {
            return Arrays.stream(Symbol.values())
                    .filter(symbol -> symbol.keyword.equals(keyword))
                    .findFirst()
                    .orElseThrow();
        }
    }

    static class Queries {

        private final List<SymbolQuery> symbolQueries;

        public Queries(List<SymbolQuery> symbolQueries) {
            this.symbolQueries = symbolQueries;
        }
    }

    static class SymbolQuery {

        private final Symbol symbol;

        public SymbolQuery(String input) {
            this.symbol = Symbol.of(input);
        }
    }
}
