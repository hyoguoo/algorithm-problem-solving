/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 33709
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DementiaPreventionRules {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();

        System.out.print(solution(bufferedReader.readLine()));
    }

    public static int solution(String slogan) {
        return Arrays.stream(slogan.split("[.|:#]"))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
