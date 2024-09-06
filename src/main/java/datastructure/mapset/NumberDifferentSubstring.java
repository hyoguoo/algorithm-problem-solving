/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11478
 * Cheat Level: 0
 * Algorithm: Set / String
 */

package datastructure.mapset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class NumberDifferentSubstring {

    public static void main(String[] args) throws IOException {
        System.out.println(
                solution(
                        new BufferedReader(new InputStreamReader(System.in)).readLine()
                )
        );
    }

    private static int solution(String s) {
        Set<String> stringSet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                stringSet.add(s.substring(i, j));
            }
        }

        return stringSet.size();
    }
}
