/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2675
 */

package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RepeatingCharacters {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < length; i++) {
            String[] str = bufferedReader.readLine().split(" ");
            StringBuilder stringBuilder = getString(str);
            System.out.println(stringBuilder);
        }
    }

    private static StringBuilder getString(String[] str) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = Integer.parseInt(str[0]);
        String string = str[1];
        for (int j = 0; j < string.length(); j++) {
            stringBuilder.append(String.valueOf(string.charAt(j)).repeat(count));
        }
        return stringBuilder;
    }
}
