/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17202
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PhoneNumberCompatibility {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String phoneNumber1 = bufferedReader.readLine();
        String phoneNumber2 = bufferedReader.readLine();

        System.out.print(solution(phoneNumber1, phoneNumber2));
    }

    private static String solution(String phoneNumber1, String phoneNumber2) {
        StringBuilder currentNumber = new StringBuilder();
        for (int i = 0; i < phoneNumber1.length(); i++) {
            currentNumber.append(phoneNumber1.charAt(i))
                    .append(phoneNumber2.charAt(i));
        }
        while (currentNumber.length() > 2) {
            StringBuilder nextNumber = new StringBuilder();
            for (int i = 0; i < currentNumber.length() - 1; i++) {
                int sum = Character.getNumericValue(currentNumber.charAt(i))
                        + Character.getNumericValue(currentNumber.charAt(i + 1));
                nextNumber.append(sum % 10);
            }
            currentNumber = nextNumber;
        }

        return currentNumber.toString();
    }
}
