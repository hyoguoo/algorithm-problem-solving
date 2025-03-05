/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2890
 * Cheat Level: 0
 * Algorithm: String / Sort
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Kayak {

    private static final int KAYAK_COUNT = 9;
    private static final int KAYAK_SIZE = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] sizeInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rowSize = sizeInfo[0];
        int colSize = sizeInfo[1];
        char[][] map = new char[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            map[i] = bufferedReader.readLine().toCharArray();
        }

        System.out.print(solution(map));
    }

    private static String solution(char[][] map) {
        KayakInfo[] kayakInfos = getKayakInfos(map);

        int[] kayakRank = getKayakRank(kayakInfos);

        return IntStream.range(1, KAYAK_COUNT + 1)
                .mapToObj(i -> String.valueOf(kayakRank[i]))
                .collect(Collectors.joining("\n"));
    }

    private static KayakInfo[] getKayakInfos(char[][] map) {
        KayakInfo[] kayakInfos = new KayakInfo[KAYAK_COUNT + 1];

        for (char[] line : map) {
            int c = map[0].length - 2;
            while (c >= 0) {
                if (!Character.isDigit(line[c])) {
                    c--;
                    continue;
                }
                int kayakNumber = line[c] - '0';
                kayakInfos[kayakNumber] = new KayakInfo(kayakNumber, c);
                c -= KAYAK_SIZE;
            }
        }
        return kayakInfos;
    }

    private static int[] getKayakRank(KayakInfo[] kayakInfos) {
        Arrays.sort(kayakInfos, 1, KAYAK_COUNT + 1, Comparator.comparingInt(k -> -k.position));

        int[] kayakRank = new int[KAYAK_COUNT + 1];
        int rank = 1;
        for (int i = 1; i <= KAYAK_COUNT; i++) {
            if (i > 1 && kayakInfos[i].position == kayakInfos[i - 1].position) {
                kayakRank[kayakInfos[i].number] = kayakRank[kayakInfos[i - 1].number];
            } else {
                kayakRank[kayakInfos[i].number] = rank;
                rank++;
            }
        }

        return kayakRank;
    }

    static class KayakInfo {

        private final int number;
        private final int position;

        KayakInfo(int number, int position) {
            this.number = number;
            this.position = position;
        }
    }
}
