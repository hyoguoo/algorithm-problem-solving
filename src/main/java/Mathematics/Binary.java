/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3460
 * Cheat Level: 0
 * Algorithm: Binary
 */

package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Binary {

    public static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < length; i++) {
            int number = Integer.parseInt(bufferedReader.readLine());
            getOnePosition(number);
        }

        System.out.println(stringBuilder);
    }

    public static void getOnePosition(int number) {
        int index = 0;
        while (number != 0) {
            if (number % 2 == 1) stringBuilder.append(index).append(" ");
            number /= 2;
            index++;
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("\n");
    }
}
