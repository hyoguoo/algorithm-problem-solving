/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1990
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimePalindrome {

    private static final int MAX = 100_000_000;
    private static final boolean[] IS_PRIME = new boolean[MAX + 1];

    static {
        Arrays.fill(IS_PRIME, true);
        IS_PRIME[0] = IS_PRIME[1] = false;

        for (int i = 2; i * i <= MAX; i++) {
            if (IS_PRIME[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    IS_PRIME[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] interval = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(
                Stream.concat(
                                solution(interval[0], interval[1]).stream(),
                                Stream.of(-1)
                        )
                        .map(String::valueOf)
                        .collect(Collectors.joining("\n"))
        );
    }

    private static List<Integer> solution(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(n -> n <= MAX && IS_PRIME[n] && isPalindrome(n))
                .boxed()
                .collect(Collectors.toList());
    }

    private static boolean isPalindrome(int n) {
        return String.valueOf(n).contentEquals(new StringBuilder(String.valueOf(n)).reverse());
    }
}
