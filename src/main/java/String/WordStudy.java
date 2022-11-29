/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1157
 */

package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WordStudy {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().toUpperCase().split("");

        Map<String, Integer> map = new HashMap<>();

        for (String string : strings) map.put(string, map.getOrDefault(string, 0) + 1);

        ArrayList<String> list = new ArrayList<>();
        Integer max = Collections.max(map.values());

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(max)) list.add(entry.getKey());
        }

        System.out.println(list.size() == 1 ? list.get(0) : "?");
    }
}
