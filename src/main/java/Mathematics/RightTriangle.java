/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4153
 */

package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RightTriangle {

    static final String EXIT = "0 0 0";
    static final String RIGHT = "right";
    static final String WRONG = "wrong";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = bufferedReader.readLine();
            if (input.equals(EXIT)) break;
            int[] numbers = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(isRightTriangle(numbers) ? RIGHT : WRONG);
        }
    }

    private static boolean isRightTriangle(int[] numbers) {
        Arrays.sort(numbers);
        int a = numbers[0];
        int b = numbers[1];
        int c = numbers[2];

        return a * a + b * b == c * c;
    }
}
