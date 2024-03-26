/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 26069
 * Cheat Level: 0
 * Algorithm: Map
 */

package datastructure.mapset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class StickyChongChong {

    static final BufferedReader BUFFERED_READER =
            new BufferedReader(new InputStreamReader(System.in));
    static final String INIT_CONSTANT = "ChongChong";

    public static void main(String[] args) throws IOException {
        int recordCount = Integer.parseInt(BUFFERED_READER.readLine());

        System.out.print(solution(recordCount));
    }

    private static int solution(int recordCount) throws IOException {
        Set<String> set = new HashSet<>();
        set.add(INIT_CONSTANT);
        while (recordCount-- > 0) {
            String[] line = BUFFERED_READER.readLine().split(" ");
            String name1 = line[0];
            String name2 = line[1];

            if (set.contains(name1)) {
                set.add(name2);
            } else if (set.contains(name2)) {
                set.add(name1);
            }
        }

        return set.size();
    }
}
