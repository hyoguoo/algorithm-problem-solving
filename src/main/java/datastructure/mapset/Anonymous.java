/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1764
 * Cheat Level: 0
 * Algorithm: Map
 */

package datastructure.mapset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Anonymous {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = numbers[0];
        int y = numbers[1];

        List<String> results = new ArrayList<>();
        Map<String, Integer> mapOfStrings = new HashMap<>();
        for (int i = 0; i < x; i++) mapOfStrings.put(bufferedReader.readLine(), 0);

        for (int i = 0; i < y; i++) {
            String str = bufferedReader.readLine();
            if (mapOfStrings.containsKey(str)) results.add(str);
        }

        Collections.sort(results);
        System.out.println(results.size());
        for (String result : results) System.out.println(result);
    }
}
