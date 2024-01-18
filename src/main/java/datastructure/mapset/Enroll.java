/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 13414
 * Cheat Level: 0
 * Algorithm: Set
 */

package datastructure.mapset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class Enroll {

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int limit = info[0];
        int count = info[1];

        LinkedHashSet<String> linkedHashSet = enrollStudents(count);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < limit; i++) {
            if (linkedHashSet.isEmpty()) break;
            stringBuilder.append(linkedHashSet.iterator().next()).append("\n");
            linkedHashSet.remove(linkedHashSet.iterator().next());
        }

        System.out.println(stringBuilder);
    }

    private static LinkedHashSet<String> enrollStudents(int count) throws IOException {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        for (int i = 0; i < count; i++) {
            String input = bufferedReader.readLine();
            linkedHashSet.remove(input);
            linkedHashSet.add(input);
        }
        return linkedHashSet;
    }
}
