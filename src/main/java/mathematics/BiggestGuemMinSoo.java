/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1526
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class BiggestGuemMinSoo {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        System.out.print(solution(n));
    }

    private static int solution(int n) {
        return IntStream.iterate(n, i -> i - 1)
                .filter(BiggestGuemMinSoo::isFourOrSeven)
                .findFirst()
                .orElse(0);
    }

    private static boolean isFourOrSeven(int n) {
        return String.valueOf(n).chars().allMatch(c -> c == '4' || c == '7');
    }
}
