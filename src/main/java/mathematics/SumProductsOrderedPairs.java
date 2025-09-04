/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 13900
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class SumProductsOrderedPairs {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(numbers));
    }

    private static BigInteger solution(int[] numbers) {
        BigInteger sum = Arrays.stream(numbers)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ZERO, BigInteger::add);

        BigInteger result = BigInteger.ZERO;

        for (int number : numbers) {
            BigInteger bigInteger = BigInteger.valueOf(number);
            sum = sum.subtract(bigInteger);
            result = result.add(bigInteger.multiply(sum));
        }

        return result;
    }
}
