/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3009
 * Cheat Level: 0
 * Algorithm: Geometry
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FourthDot {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> mapX = new HashMap<>();
        Map<Integer, Integer> mapY = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            int[] coordinate = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = coordinate[0];
            int y = coordinate[1];
            mapX.put(x, mapX.getOrDefault(x, 0) + 1);
            mapY.put(y, mapY.getOrDefault(y, 0) + 1);
        }

        System.out.println(findValueOf(mapX) + " " + findValueOf(mapY));
    }

    private static int findValueOf(Map<Integer, Integer> map) {
        return map.keySet().stream().filter(key -> map.get(key) == 1).findFirst().orElse(-1);
    }
}
