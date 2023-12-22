/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 25192
 * Cheat Level: 0
 * Algorithm: Set
 */

package datastructure.mapset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class PersonableBrightGomGom {

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final String ENTER = "ENTER";

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bufferedReader.readLine());

        System.out.println(solution(n));
    }

    private static int solution(int n) throws IOException {
        Set<String> set = new HashSet<>();
        int count = 0;

        while (n-- > 0) {
            String s = bufferedReader.readLine();
            if (s.equals(ENTER)) {
                count += set.size();
                set.clear();
            } else {
                set.add(s);
            }
        }

        count += set.size();

        return count;
    }
}
