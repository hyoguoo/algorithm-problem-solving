/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1969
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DNA {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int dnaCount = info[0];
        Nucleotide[][] dnaInfos = new Nucleotide[dnaCount][];
        for (int i = 0; i < dnaCount; i++) {
            String line = bufferedReader.readLine();
            dnaInfos[i] = new Nucleotide[line.length()];
            for (int j = 0; j < line.length(); j++) {
                dnaInfos[i][j] = Nucleotide.of(String.valueOf(line.charAt(j)));
            }
        }

        System.out.print(solution(dnaInfos));
    }

    private static ResultInfo solution(Nucleotide[][] dnaInfos) {
        int dnaLength = dnaInfos[0].length;
        StringBuilder dna = new StringBuilder();
        int hammingDistance = 0;

        for (int i = 0; i < dnaLength; i++) {
            int[] counts = new int[Nucleotide.values().length];
            Nucleotide maxNucleotide = findMostFrequentNucleotide(dnaInfos, i, counts);
            int maxCount = counts[maxNucleotide.getIndex()];

            hammingDistance += (dnaInfos.length - maxCount);
            dna.append(maxNucleotide.getSymbol());
        }

        return new ResultInfo(dna.toString(), hammingDistance);
    }

    private static Nucleotide findMostFrequentNucleotide(Nucleotide[][] dnaInfos, int columnIndex, int[] counts) {
        for (Nucleotide[] dnaInfo : dnaInfos) {
            int index = dnaInfo[columnIndex].getIndex();
            counts[index]++;
        }

        int maxCount = -1;
        int maxIndex = -1;

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                maxIndex = i;
            }
        }

        return Nucleotide.VALUES[maxIndex];
    }

    enum Nucleotide {
        A("A", 0),
        C("C", 1),
        G("G", 2),
        T("T", 3);

        private static final Nucleotide[] VALUES = values();
        private final String symbol;
        private final int index;

        Nucleotide(String symbol, int index) {
            this.symbol = symbol;
            this.index = index;
        }

        public static Nucleotide of(String s) {
            return Arrays.stream(VALUES)
                    .filter(nucleotide -> nucleotide.symbol.equals(s))
                    .findFirst()
                    .orElseThrow();
        }

        public String getSymbol() {
            return symbol;
        }

        public int getIndex() {
            return index;
        }
    }

    private static class ResultInfo {

        private final String dna;
        private final int hammingDistance;

        public ResultInfo(String dna, int hammingDistance) {
            this.dna = dna;
            this.hammingDistance = hammingDistance;
        }

        @Override
        public String toString() {
            return dna + "\n" + hammingDistance;
        }
    }
}
