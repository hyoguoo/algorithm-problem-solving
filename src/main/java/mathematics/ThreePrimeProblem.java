/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11502
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
import java.util.stream.Collectors;

public class ThreePrimeProblem {

    private static final int MAX = 991;
    private static final boolean[] IS_PRIME = new boolean[MAX + 1];
    private static final List<Integer> PRIME_LIST = new ArrayList<>();
    private static final int PICK_COUNT = 3;

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
        int testCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            stringBuilder
                    .append(solution(Integer.parseInt(bufferedReader.readLine())))
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static String solution(int n) {
        int[] result = new int[PICK_COUNT];

        boolean threePrime = findThreePrime(0, result, n);

        return threePrime
                ? Arrays.stream(result)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "))
                : "0";
    }

    private static boolean findThreePrime(int index, int[] result, int n) {
        if (index == PICK_COUNT) {
            return Arrays.stream(result).sum() == n;
        }

        for (int prime : PRIME_LIST) {
            if (prime > n) {
                break;
            }
            result[index] = prime;
            if (findThreePrime(index + 1, result, n)) {
                return true;
            }
        }

        return false;
    }
}
