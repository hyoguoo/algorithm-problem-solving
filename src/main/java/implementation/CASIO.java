/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15963
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CASIO {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = bufferedReader.readLine().split(" ");

        System.out.print(solution(info[0], info[1]) ? 1 : 0);
    }

    private static boolean solution(String a, String b) {
        return a.equals(b);
    }
}
