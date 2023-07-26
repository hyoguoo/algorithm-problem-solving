/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2864
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DifferenceBetween5And6 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] stringNumbers = bufferedReader.readLine().split(" ");
        solution(stringNumbers[0], stringNumbers[1]);
    }

    private static void solution(String stringNumber1, String stringNumber2) {
        System.out.println((getMin(stringNumber1) + getMin(stringNumber2)) + " " + (getMax(stringNumber1) + getMax(stringNumber2)));
    }

    private static int getMin(String stringNumber) {
        return Integer.parseInt(stringNumber.replaceAll("6", "5"));
    }

    private static int getMax(String stringNumber) {
        return Integer.parseInt(stringNumber.replaceAll("5", "6"));
    }
}
