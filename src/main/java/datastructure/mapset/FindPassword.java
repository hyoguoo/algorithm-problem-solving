/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17219
 * Cheat Level: 0
 * Algorithm: Map
 */

package datastructure.mapset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindPassword {

    final static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int length = info[0];
        int findLength = info[1];

        for (int i = 0; i < length; i++) {
            String[] strings = bufferedReader.readLine().split(" ");
            map.put(strings[0], strings[1]);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < findLength; i++) stringBuilder.append(map.get(bufferedReader.readLine())).append("\n");
        System.out.println(stringBuilder);
    }
}
