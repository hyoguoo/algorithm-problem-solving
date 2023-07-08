/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2358
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class HardwoodSpecies {

    final static Map<String, Integer> speciesMap = new TreeMap<>();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = bufferedReader.readLine();
            if (Objects.isNull(line)) break;
            speciesMap.put(line, speciesMap.getOrDefault(line, 0) + 1);
            count++;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (String species : speciesMap.keySet()) {
            stringBuilder.append(species).append(" ").append(String.format("%.4f", (double) speciesMap.get(species) / count * 100)).append("\n");
        }

        System.out.println(stringBuilder);
    }
}
