/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17256
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class OverflowingWithSweetness {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] aInput = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] cInput = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        CakeNumber a = new CakeNumber(aInput[0], aInput[1], aInput[2]);
        CakeNumber c = new CakeNumber(cInput[0], cInput[1], cInput[2]);

        System.out.print(solution(a, c));
    }

    private static CakeNumber solution(CakeNumber a, CakeNumber c) {
        return a.calculateRequiredNumberFrom(c);
    }

    static class CakeNumber {

        private final int x;
        private final int y;
        private final int z;

        public CakeNumber(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public CakeNumber calculateRequiredNumberFrom(CakeNumber result) {
            int bX = result.x - this.z;
            int bY = result.y / this.y;
            int bZ = result.z - this.x;
            return new CakeNumber(bX, bY, bZ);
        }

        @Override
        public String toString() {
            return x + " " + y + " " + z;
        }
    }
}
