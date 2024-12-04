/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 24389
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class TwoComplement {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        System.out.print(solution(n));
    }

    private static long solution(int n) {
        String binaryString = String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');

        String twoComplementString = getTwoComplementString(binaryString);

        return countDifference(binaryString, twoComplementString);
    }

    private static String getTwoComplementString(String binaryString) {
        String invertedBinaryString = binaryString
                .replace('0', '2')
                .replace('1', '0')
                .replace('2', '1');

        int invertedNumber = Integer.parseUnsignedInt(invertedBinaryString, 2);
        int twoComplementNumber = invertedNumber + 1;

        return String.format("%32s", Integer.toBinaryString(twoComplementNumber))
                .replace(' ', '0');
    }

    private static long countDifference(String binaryString, String twoComplementString) {
        return IntStream.range(0, 32)
                .filter(i -> binaryString.charAt(i) != twoComplementString.charAt(i))
                .count();
    }
}
