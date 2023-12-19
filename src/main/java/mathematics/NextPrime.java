/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4134
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class NextPrime {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bufferedReader.readLine());
        List<Long> numberList = new ArrayList<>();

        for (int i = 0; i < testCase; i++) {
            numberList.add(Long.parseLong(bufferedReader.readLine()));
        }

        solution(numberList);
    }

    private static void solution(List<Long> numberList) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Long number : numberList) {
            stringBuilder.append(findNextPrime(number)).append("\n");
        }

        System.out.print(stringBuilder);
    }

    private static long findNextPrime(long number) {
        BigInteger bigInteger = BigInteger.valueOf(number);

        if (bigInteger.isProbablePrime(10)) return number;
        else return bigInteger.nextProbablePrime().longValue();
    }
}
