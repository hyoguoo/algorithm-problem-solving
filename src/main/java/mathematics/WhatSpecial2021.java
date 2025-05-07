/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 24039
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class WhatSpecial2021 {

    private static final int MAX = 10_000 * 2;
    private static final boolean[] IS_PRIME = new boolean[MAX + 1];
    private static final List<Integer> PRIME_LIST = new ArrayList<>();

    static {
        Arrays.fill(IS_PRIME, true);
        IS_PRIME[0] = false;

        for (int i = 2; i <= Math.sqrt(MAX); i++) {
            if (IS_PRIME[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    IS_PRIME[j] = false;
                }
            }
        }

        for (int i = 2; i <= MAX; i++) {
            if (IS_PRIME[i]) {
                PRIME_LIST.add(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(solution(Integer.parseInt(bufferedReader.readLine())));
    }

    private static int solution(int start) {
        return IntStream.range(start + 1, MAX + 1)
                .filter(WhatSpecial2021::isSpecial)
                .findFirst()
                .orElseThrow();
    }

    private static boolean isSpecial(int n) {
        for (int i = 0; i < PRIME_LIST.size() - 1; i++) {
            if (PRIME_LIST.get(i) * PRIME_LIST.get(i + 1) == n) {
                return true;
            }
        }
        return false;
    }
}
