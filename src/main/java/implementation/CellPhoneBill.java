/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1267
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CellPhoneBill {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] times = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(times));
    }

    private static String solution(int[] times) {
        int yBill = 0;
        int mBill = 0;

        for (int time : times) {
            yBill += (time / Bill.Y.unitTime + 1) * Bill.Y.unitFee;
            mBill += (time / Bill.M.unitTime + 1) * Bill.M.unitFee;
        }

        if (yBill < mBill) {
            return "Y " + yBill;
        } else if (yBill > mBill) {
            return "M " + mBill;
        } else {
            return "Y M " + yBill;
        }
    }

    enum Bill {
        Y(30, 10),
        M(60, 15);

        private final int unitTime;
        private final int unitFee;

        Bill(int unitTime, int unitFee) {
            this.unitTime = unitTime;
            this.unitFee = unitFee;
        }
    }
}
