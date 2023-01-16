
/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1629
 * Cheat Level: 1
 * Algorithm: Mathematics
 */

package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Multiple {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(numbers[0], numbers[1], numbers[2]));
    }

    private static int solution(int number1, int number2, int number3) {
        BigInteger bigInteger1 = BigInteger.valueOf(number1);
        BigInteger bigInteger2 = BigInteger.valueOf(number2);
        BigInteger bigInteger3 = BigInteger.valueOf(number3);

        return bigInteger1.modPow(bigInteger2, bigInteger3).intValue();
    }
}
