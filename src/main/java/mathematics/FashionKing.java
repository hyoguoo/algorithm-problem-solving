/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9375
 * Cheat Level: 0
 * Algorithm: Mathematics / Combination / DataStructure.Map
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FashionKing {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            int clothesCount = Integer.parseInt(bufferedReader.readLine());
            String[] clotheTypes = new String[clothesCount];

            for (int i = 0; i < clothesCount; i++) {
                clotheTypes[i] = bufferedReader.readLine().split(" ")[1];
            }

            stringBuilder.append(solution(clotheTypes)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(String[] clotheTypes) {
        Map<String, Integer> clotheMap = new HashMap<>();

        Arrays.stream(clotheTypes)
                .forEach(
                        clotheType ->
                                clotheMap.put(
                                        clotheType,
                                        clotheMap.getOrDefault(clotheType, 0) + 1
                                )
                );

        return getCombination(clotheMap);
    }

    private static int getCombination(Map<String, Integer> clotheMap) {
        int result = clotheMap
                .keySet()
                .stream()
                .mapToInt(key -> clotheMap.get(key) + 1)
                .reduce(1, (a, b) -> a * b);

        return result - 1;
    }
}
