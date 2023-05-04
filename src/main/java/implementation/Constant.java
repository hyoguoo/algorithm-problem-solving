/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2908
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Constant {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bufferedReader.readLine().split(" ");

        int num1 = Integer.parseInt(new StringBuffer(str[0]).reverse().toString());
        int num2 = Integer.parseInt(new StringBuffer(str[1]).reverse().toString());
        System.out.println(Math.max(num1, num2));
    }
}
