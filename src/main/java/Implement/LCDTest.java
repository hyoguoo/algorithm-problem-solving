/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2290
 */

package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LCDTest {
    private static final String BAR_HORIZONTAL = "-";
    private static final String BAR_VERTICAL = "|";
    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = bufferedReader.readLine().split(" ");
        int size = Integer.parseInt(info[0]);
        int[] numbers = Arrays.stream(info[1].split("")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(numbers, size));
    }

    private static String solution(int[] numbers, int size) {
        StringBuilder result = new StringBuilder();
        int height = 2 * size + 3;

        for (int line = 0; line < height; line++) {
            for (int number : numbers) {
                switch (number) {
                    case 0:
                        if (line == 0 || line == height - 1)
                            result.append(extractBarHorizontalMiddle(size));
                        else if (line == height / 2)
                            result.append(extractSpace(size));
                        else
                            result.append(extractBarVerticalBoth(size));
                        break;
                    case 1:
                        if (line == 0 || line == height - 1 || line == height / 2)
                            result.append(extractSpace(size));
                        else
                            result.append(extractBarVerticalRight(size));
                        break;
                    case 2:
                        if (line == 0 || line == height - 1 || line == height / 2)
                            result.append(extractBarHorizontalMiddle(size));
                        else if (line < height / 2)
                            result.append(extractBarVerticalRight(size));
                        else
                            result.append(extractBarVerticalLeft(size));
                        break;
                    case 3:
                        if (line == 0 || line == height - 1 || line == height / 2)
                            result.append(extractBarHorizontalMiddle(size));
                        else
                            result.append(extractBarVerticalRight(size));
                        break;
                    case 4:
                        if (line == 0 || line == height - 1)
                            result.append(extractSpace(size));
                        else if (line == height / 2)
                            result.append(extractBarHorizontalMiddle(size));
                        else if (line < height / 2)
                            result.append(extractBarVerticalBoth(size));
                        else
                            result.append(extractBarVerticalRight(size));
                        break;
                    case 5:
                        if (line == 0 || line == height - 1 || line == height / 2)
                            result.append(extractBarHorizontalMiddle(size));
                        else if (line < height / 2)
                            result.append(extractBarVerticalLeft(size));
                        else
                            result.append(extractBarVerticalRight(size));
                        break;
                    case 6:
                        if (line == 0 || line == height - 1 || line == height / 2)
                            result.append(extractBarHorizontalMiddle(size));
                        else if (line < height / 2)
                            result.append(extractBarVerticalLeft(size));
                        else
                            result.append(extractBarVerticalBoth(size));
                        break;
                    case 7:
                        if (line == 0)
                            result.append(extractBarHorizontalMiddle(size));
                        else if (line == height - 1 || line == height / 2)
                            result.append(extractSpace(size));
                        else
                            result.append(extractBarVerticalRight(size));
                        break;
                    case 8:
                        if (line == 0 || line == height - 1 || line == height / 2)
                            result.append(extractBarHorizontalMiddle(size));
                        else
                            result.append(extractBarVerticalBoth(size));
                        break;
                    case 9:
                        if (line == 0 || line == height - 1 || line == height / 2)
                            result.append(extractBarHorizontalMiddle(size));
                        else if (line < height / 2)
                            result.append(extractBarVerticalBoth(size));
                        else
                            result.append(extractBarVerticalRight(size));
                        break;
                }
                result.append(SPACE);
            }
            result.deleteCharAt(result.length() - 1);
            result.append("\n");
        }

        return result.toString();
    }

    private static String extractBarHorizontalMiddle(int size) {
        return SPACE + BAR_HORIZONTAL.repeat(size) + SPACE;
    }

    private static String extractBarVerticalBoth(int size) {
        return BAR_VERTICAL + SPACE.repeat(size) + BAR_VERTICAL;
    }

    private static String extractBarVerticalLeft(int size) {
        return BAR_VERTICAL + SPACE.repeat(size + 1);
    }

    private static String extractBarVerticalRight(int size) {
        return SPACE.repeat(size + 1) + BAR_VERTICAL;
    }

    private static String extractSpace(int size) {
        return SPACE.repeat(size + 2);
    }
}
