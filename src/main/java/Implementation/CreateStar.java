/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2438 / 2439 / 2440 / 2441 / 2442 / 2443 / 2444
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateStar {

    static char star = '*';
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        solution7(length);
        System.out.print(stringBuilder);
    }

    public static void solution1(int length) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) addStar();
            addNewline();
        }
    }

    public static void solution2(int length) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) addSpace();
            for (int j = 0; j <= i; j++) addStar();
            addNewline();
        }
    }

    public static void solution3(int length) {
        for (int i = length; i > 0; i--) {
            for (int j = 0; j < i; j++) addStar();
            addNewline();
        }
    }

    public static void solution4(int length) {
        for (int i = length; i > 0; i--) {
            for (int j = 0; j < length - i; j++) addSpace();
            for (int j = 0; j < i; j++) addStar();
            addNewline();
        }
    }

    public static void solution5(int length) {
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < length - i; j++) addSpace();
            for (int j = 0; j < (i * 2) - 1; j++) addStar();
            addNewline();
        }
    }

    public static void solution6(int length, boolean printFirstLine) {
        for (int i = length; i >= 1; i--) {
            if (!printFirstLine && i == length) continue;
            for (int j = 0; j < length - i; j++) addSpace();
            for (int j = 0; j < (i * 2) - 1; j++) addStar();
            addNewline();
        }
    }

    public static void solution7(int length) {
        solution5(length);
        solution6(length, false);
    }

    private static void addNewline() {
        stringBuilder.append("\n");
    }

    private static void addStar() {
        stringBuilder.append(star);
    }

    private static void addSpace() {
        stringBuilder.append(" ");
    }
}
