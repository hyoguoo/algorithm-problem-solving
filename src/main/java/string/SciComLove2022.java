/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 24937
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SciComLove2022 {

    private static final String SCI_COM_LOVE = "SciComLove";
    private static final int SCI_COM_LOVE_LENGTH = SCI_COM_LOVE.length();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(solution(Integer.parseInt(bufferedReader.readLine())));
    }

    private static String solution(int n) {
        return SCI_COM_LOVE.substring(n % SCI_COM_LOVE_LENGTH)
                + SCI_COM_LOVE.substring(0, n % SCI_COM_LOVE_LENGTH);
    }
}
