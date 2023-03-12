/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2448
 * Cheat Level: 2
 * Algorithm: Implementation / Recursion
 */

package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateStar11 {

    final static char STAR = '*';
    final static char SPACE = ' ';
    static char[][] starArray;
    static int TARGET;
    static int HEIGHT;
    static int WIDTH;

    public static void main(String[] args) throws IOException {
        init();
        recursive(0, HEIGHT - 1, TARGET);
        print();
    }

    private static void print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                stringBuilder.append(starArray[i][j]);
            }
            stringBuilder.append("\n");
        }
        System.out.print(stringBuilder);
    }

    private static void recursive(int height, int width, int target) {
        if (target == 3) {
            starArray[height][width] = STAR;
            starArray[height + 1][width - 1]
                    = starArray[height + 1][width + 1]
                    = STAR;
            starArray[height + 2][width - 2]
                    = starArray[height + 2][width - 1]
                    = starArray[height + 2][width]
                    = starArray[height + 2][width + 1]
                    = starArray[height + 2][width + 2]
                    = STAR;
            return;
        }
        int divide = target / 2;
        recursive(height, width, divide);
        recursive(height + divide, width - divide, divide);
        recursive(height + divide, width + divide, divide);
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        TARGET = Integer.parseInt(bufferedReader.readLine());
        HEIGHT = TARGET;
        WIDTH = TARGET * 2 - 1;
        starArray = new char[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                starArray[i][j] = SPACE;
            }
        }
    }
}
