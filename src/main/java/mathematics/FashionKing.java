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
import java.util.HashMap;
import java.util.Map;

public class FashionKing {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < length; i++) {
            Map<String, Integer> clothes = new HashMap<>();
            int count = Integer.parseInt(bufferedReader.readLine());
            for (int j = 0; j < count; j++) {
                String[] input = bufferedReader.readLine().split(" ");
                String clotheType = input[1];
                clothes.put(clotheType, clothes.getOrDefault(clotheType, 0) + 1);
            }
            System.out.println(getCombination(clothes));
        }

    }

    private static int getCombination(Map<String, Integer> clothes) {
        int result = 1;
        for (String key : clothes.keySet()) result *= clothes.get(key) + 1;
        return result - 1;
    }
}
