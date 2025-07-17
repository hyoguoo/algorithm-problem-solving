/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11815
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class EvenOrOdd {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        StringBuilder stringBuilder = new StringBuilder();
        BigInteger[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .map(BigInteger::new)
                .toArray(BigInteger[]::new);

        Arrays.stream(numbers)
                .forEach(
                        number -> stringBuilder
                                .append(solution(number) ? 1 : 0)
                                .append(" ")
                );

        System.out.print(stringBuilder.toString().trim());
    }

    private static boolean solution(BigInteger number) {
        return number
                .sqrt()
                .multiply(number.sqrt())
                .equals(number);
    }
}
