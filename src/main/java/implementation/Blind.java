/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2799
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Blind {

    private static final int BLIND_HEIGHT = 4;
    private static final int BLIND_WIDTH = 4;
    private static final int BLIND_GAP = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] sizeInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sizeN = sizeInfo[0];
        int sizeM = sizeInfo[1];

        int width = sizeN * BLIND_HEIGHT + BLIND_GAP * (sizeN + 1);
        int height = sizeM * BLIND_WIDTH + BLIND_GAP * (sizeM + 1);
        Symbol[][] symbols = new Symbol[width][height];

        for (int w = 0; w < width; w++) {
            symbols[w] = Arrays.stream(bufferedReader.readLine().split(""))
                    .map(Symbol::of)
                    .toArray(Symbol[]::new);
        }

        System.out.print(solution(symbols, sizeN, sizeM));
    }

    private static String solution(Symbol[][] symbols, int sizeN, int sizeM) {
        int[] counts = new int[BLIND_HEIGHT + 1];

        for (int n = 0; n < sizeN; n++) {
            int posN = n * BLIND_HEIGHT + BLIND_GAP * (n + 1);
            for (int m = 0; m < sizeM; m++) {
                int posM = m * BLIND_WIDTH + BLIND_GAP * (m + 1);
                int type = findBlindType(symbols, posN, posM);
                counts[type]++;
            }
        }
        return Arrays.stream(counts)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    private static int findBlindType(Symbol[][] symbols, int posN, int posM) {
        int type = 0;

        for (int n = 0; n < BLIND_HEIGHT; n++) {
            if (symbols[posN + n][posM] == Symbol.BLIND) {
                type++;
            }
        }

        return type;
    }

    enum Symbol {
        BLIND("*"),
        SPACE("."),
        WALL("#");

        private final String value;

        Symbol(String value) {
            this.value = value;
        }

        public static Symbol of(String value) {
            return Arrays.stream(Symbol.values())
                    .filter(symbol -> symbol.value.equals(value))
                    .findFirst()
                    .orElseThrow();
        }
    }
}
