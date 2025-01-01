/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2438 / 2439 / 2440 / 2441 / 2442 / 2443 / 2444 / 2445 / 2446 / 2522
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateStar1to16 {

    private static final char STAR = '*';
    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        solution16(length);
        System.out.print(stringBuilder);
    }

    private static void solution1(int length) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                addStar();
            }
            addNewline();
        }
    }

    private static void solution2(int length) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                addSpace();
            }
            for (int j = 0; j <= i; j++) {
                addStar();
            }
            addNewline();
        }
    }

    private static void solution3(int length) {
        for (int i = length; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                addStar();
            }
            addNewline();
        }
    }

    private static void solution4(int length) {
        for (int i = length; i > 0; i--) {
            for (int j = 0; j < length - i; j++) {
                addSpace();
            }
            for (int j = 0; j < i; j++) {
                addStar();
            }
            addNewline();
        }
    }

    private static void solution5(int length) {
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < length - i; j++) {
                addSpace();
            }
            for (int j = 0; j < (i * 2) - 1; j++) {
                addStar();
            }
            addNewline();
        }
    }

    private static void solution6(int length, boolean printFirstLine) {
        for (int i = length; i >= 1; i--) {
            if (!printFirstLine && i == length) {
                continue;
            }
            for (int j = 0; j < length - i; j++) {
                addSpace();
            }
            for (int j = 0; j < (i * 2) - 1; j++) {
                addStar();
            }
            addNewline();
        }
    }

    private static void solution7(int length) {
        solution5(length);
        solution6(length, false);
    }

    private static void solution8(int length) {
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= i; j++) {
                addStar();
            }
            for (int j = 1; j <= (length - i) * 2; j++) {
                addSpace();
            }
            for (int j = 1; j <= i; j++) {
                addStar();
            }
            addNewline();
        }
        for (int i = length - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                addStar();
            }
            for (int j = 1; j <= (length - i) * 2; j++) {
                addSpace();
            }
            for (int j = 1; j <= i; j++) {
                addStar();
            }
            addNewline();
        }
    }

    private static void solution9(int length) {
        for (int i = length; i >= 1; i--) {
            for (int j = 1; j <= length - i; j++) {
                addSpace();
            }
            for (int j = 1; j <= i * 2 - 1; j++) {
                addStar();
            }
            addNewline();
        }
        for (int i = 2; i <= length; i++) {
            for (int j = 1; j <= length - i; j++) {
                addSpace();
            }
            for (int j = 1; j <= i * 2 - 1; j++) {
                addStar();
            }
            addNewline();
        }
    }

    private static void solution12(int length) {
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length - i; j++) {
                addSpace();
            }
            for (int j = 1; j <= i; j++) {
                addStar();
            }
            addNewline();
        }
        for (int i = length - 1; i >= 1; i--) {
            for (int j = 1; j <= length - i; j++) {
                addSpace();
            }
            for (int j = 1; j <= i; j++) {
                addStar();
            }
            addNewline();
        }
    }

    private static void solution13(int length) {
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= i; j++) {
                addStar();
            }
            addNewline();
        }
        for (int i = length - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                addStar();
            }
            addNewline();
        }
    }

    private static void solution15(int length) {
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length - i; j++) {
                addSpace();
            }
            addStar();
            for (int j = 1; j <= 2 * (i - 1) - 1; j++) {
                addSpace();
            }
            if (i != 1) {
                addStar();
            }
            addNewline();
        }
    }

    private static void solution16(int length) {
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length - i; j++) {
                addSpace();
            }
            for (int j = 1; j <= 2 * i - 1; j += 2) {
                addStar();
                addSpace();
            }
            addNewline();
        }
    }

    private static void addNewline() {
        stringBuilder.append("\n");
    }

    private static void addStar() {
        stringBuilder.append(STAR);
    }

    private static void addSpace() {
        stringBuilder.append(" ");
    }
}
