/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1302
 * Cheat Level: 0
 * Algorithm: Map
 */

package datastructure.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BestSeller {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            String input = bufferedReader.readLine();
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        String result = getResult(map);
        System.out.println(result);
    }

    private static String getResult(Map<String, Integer> map) {
        String result = "";
        int max = 0;

        for (String key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                result = key;
            } else if (map.get(key) == max) {
                if (result.compareTo(key) > 0) result = key;
            }
        }
        return result;
    }
}
