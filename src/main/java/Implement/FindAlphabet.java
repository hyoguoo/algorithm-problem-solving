/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10809
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindAlphabet {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = bufferedReader.readLine();
        StringBuilder stringBuilder = new StringBuilder();

        for (int asciiCode = 97; asciiCode <= 122; asciiCode++) {
            char alphabet = (char) asciiCode;
            int index = string.indexOf(alphabet);
            stringBuilder.append(index).append(" ");

        }
        System.out.println(stringBuilder.substring(0, stringBuilder.length() - 1));
    }
}
