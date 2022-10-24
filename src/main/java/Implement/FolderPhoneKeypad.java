package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FolderPhoneKeypad {
    static char[][] keypad = {{}, {'1', '.', ',', '?', '!'}, {'2', 'A', 'B', 'C'}, {'3', 'D', 'E', 'F'}, {'4', 'G', 'H', 'I'}, {'5', 'J', 'K', 'L'}, {'6', 'M', 'N', 'O'}, {'7', 'P', 'Q', 'R', 'S'}, {'8', 'T', 'U', 'V'}, {'9', 'W', 'X', 'Y', 'Z'}};


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = Arrays.stream(bufferedReader.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {
        StringBuilder result = new StringBuilder();
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (i == numbers.length - 1) {
                result.append(extractChar(numbers[i], count));
                break;
            }
            if (numbers[i] == numbers[i + 1]) {
                count++;
            } else {
                result.append(extractChar(numbers[i], count));
                count = 0;
            }
        }


        return result.toString();
    }

    public static char extractChar(int pressedNumber, int count) {
        int orderNumber = count % (keypad[pressedNumber].length);
        return keypad[pressedNumber][orderNumber];
    }
}