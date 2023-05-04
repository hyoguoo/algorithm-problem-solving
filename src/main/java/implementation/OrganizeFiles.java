/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 20291
 * Cheat Level: 0
 * Algorithm: Implementation / DataStructure.Map
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class OrganizeFiles {

    final static Map<String, Integer> map = new HashMap<>();
    final static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < length; i++) {
            String[] strings = bufferedReader.readLine().split("\\.");
            String extension = strings[1];
            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }

        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(entry -> stringBuilder.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n"));
        System.out.println(stringBuilder);
    }
}
