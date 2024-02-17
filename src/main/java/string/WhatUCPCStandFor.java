/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15904
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WhatUCPCStandFor {

    public static void main(String[] args) throws IOException {
        System.out.println(
                solution(new BufferedReader(new InputStreamReader(System.in)).readLine())
                ? "I love UCPC"
                : "I hate UCPC"
        );
    }

    private static boolean solution(String s) {
        int uIndex = s.indexOf('U');
        int cIndex = s.indexOf('C', uIndex);
        int pIndex = s.indexOf('P', cIndex);
        int nextCIndex = s.indexOf('C', pIndex);

        return uIndex != -1 && cIndex != -1 && pIndex != -1 && nextCIndex != -1;
    }
}
