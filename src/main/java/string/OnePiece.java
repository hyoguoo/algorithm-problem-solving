/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 12780
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OnePiece {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        String target = bufferedReader.readLine();

        System.out.print(solution(input, target));
    }

    private static int solution(String input, String target) {
        return (input.length() - input.replace(target, "").length())
                / target.length();
    }
}
