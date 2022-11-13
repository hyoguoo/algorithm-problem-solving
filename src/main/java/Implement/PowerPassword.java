/*
 * goormlevel
 * https://level.goorm.io
 * Monday Challenge: 6주차 문제 2
 */

package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PowerPassword {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        String[] inputString = bufferedReader.readLine().split("");
        System.out.println(solution(inputString));
    }

    public static StringBuilder solution(String[] inputString) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < inputString.length; i += 2) {
            char c = inputString[i].charAt(0);
            int number = Integer.parseInt(inputString[i + 1]);
            stringBuilder.append(getC(c, number));
        }

        return stringBuilder;

    }

    private static char getC(char c, int number) {
        c = (char) (c + number * number);
        while (c > 'z') c = (char) (c - 26);
        return c;
    }
}
