/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2358
 * Cheat Level: 3
 * Algorithm: Map
 */

package datastructure.mapset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ParallelLine {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int lineCount = Integer.parseInt(bufferedReader.readLine());
        Lien[] liens = new Lien[lineCount];

        for (int i = 0; i < lineCount; i++) {
            int[] lineInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            liens[i] = new Lien(lineInfo[0], lineInfo[1]);
        }

        System.out.print(solution(liens));
    }

    private static long solution(Lien[] liens) {
        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();

        Arrays.stream(liens).forEach(lien -> {
            xMap.put(lien.x, xMap.getOrDefault(lien.x, 0) + 1);
            yMap.put(lien.y, yMap.getOrDefault(lien.y, 0) + 1);
        });

        return countOverOne(xMap) + countOverOne(yMap);
    }

    private static long countOverOne(Map<Integer, Integer> map) {
        return map.values().stream().filter(value -> value > 1).count();
    }

    static class Lien {

        private final int x;
        private final int y;

        public Lien(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
