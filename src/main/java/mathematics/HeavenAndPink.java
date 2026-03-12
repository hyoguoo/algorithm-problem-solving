/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 31473
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HeavenAndPink {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();

        HairData pinkHairData = new HairData(
                HairColor.PINK,
                Arrays.stream(bufferedReader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray()
        );
        HairData skyBlueHairData = new HairData(
                HairColor.SKY_BLUE,
                Arrays.stream(bufferedReader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray()
        );

        System.out.print(solution(pinkHairData, skyBlueHairData));
    }

    private static String solution(HairData pinkHairData, HairData skyBlueHairData) {
        long pinkSum = pinkHairData.calculateSum();
        long skyBlueSum = skyBlueHairData.calculateSum();

        long commonDivisor = getGreatestCommonDivisor(pinkSum, skyBlueSum);

        long pinkCoefficient = skyBlueSum / commonDivisor;
        long skyBlueCoefficient = pinkSum / commonDivisor;

        return pinkCoefficient + " " + skyBlueCoefficient;
    }

    private static long getGreatestCommonDivisor(long a, long b) {
        while (b != 0) {
            a %= b;
            long temp = a;
            a = b;
            b = temp;
        }
        return a;
    }

    enum HairColor {
        PINK, SKY_BLUE
    }

    static class HairData {

        private final HairColor color;
        private final int[] lengths;

        public HairData(HairColor color, int[] lengths) {
            this.color = color;
            this.lengths = lengths;
        }

        public long calculateSum() {
            long sum = 0;
            for (int length : lengths) {
                sum += length;
            }
            return sum;
        }
    }
}

