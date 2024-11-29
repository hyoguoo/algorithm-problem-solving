/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14928
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BigNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String numberString = bufferedReader.readLine();

        System.out.print(solution(numberString));
    }

    private static int solution(String numberString) {
        int number = 0;
        for (int i = 0; i < numberString.length(); i++) {
            number = (number * 10 + (numberString.charAt(i) - '0')) % 20000303;
        }
        return number;
    }
}
