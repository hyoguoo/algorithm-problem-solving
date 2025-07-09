/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 28444
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HIARC {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        HIARCFormulas hiarcFormulas = new HIARCFormulas(numbers[0], numbers[1], numbers[2], numbers[3], numbers[4]);

        System.out.print(calculateHIARC(hiarcFormulas));
    }

    private static int calculateHIARC(HIARCFormulas hiarcFormulas) {
        return hiarcFormulas.calculate();
    }

    static class HIARCFormulas {

        private final int h;
        private final int i;
        private final int a;
        private final int r;
        private final int c;

        public HIARCFormulas(int h, int i, int a, int r, int c) {
            this.h = h;
            this.i = i;
            this.a = a;
            this.r = r;
            this.c = c;
        }

        public int calculate() {
            return calculateHI() - calculateARC();
        }

        private int calculateHI() {
            return h * i;
        }

        private int calculateARC() {
            return a * r * c;
        }
    }
}
