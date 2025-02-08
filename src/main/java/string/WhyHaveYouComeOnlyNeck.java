/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 30501
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WhyHaveYouComeOnlyNeck {

    private static final char SUSPECT_CHAR = 'S';

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            names[i] = bufferedReader.readLine();
        }

        System.out.print(solution(names));
    }

    private static String solution(String[] names) {
        return Arrays.stream(names)
                .filter(name -> name.contains(String.valueOf(SUSPECT_CHAR)))
                .findFirst()
                .orElseThrow();
    }
}
