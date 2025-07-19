/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2885
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChocolateMeals {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(solution(Integer.parseInt(bufferedReader.readLine())));
    }

    private static Result solution(int needChocolateSize) {
        int requiredChocolateSize = (int) Math.pow(2, Math.ceil(Math.log(needChocolateSize) / Math.log(2)));
        int divisionCount = 0;
        int currentChocolateSize = requiredChocolateSize;
        int myChocolate = 0;

        while (myChocolate < needChocolateSize) {
            if (myChocolate + currentChocolateSize <= needChocolateSize) {
                myChocolate += currentChocolateSize;
            }
            if (myChocolate == needChocolateSize) {
                break;
            }
            currentChocolateSize /= 2;
            divisionCount++;
        }

        return new Result(requiredChocolateSize, divisionCount);
    }

    static class Result {

        private final int chocolateSize;
        private final int divisionCount;

        public Result(int chocolateSize, int divisionCount) {
            this.chocolateSize = chocolateSize;
            this.divisionCount = divisionCount;
        }

        @Override
        public String toString() {
            return chocolateSize + " " + divisionCount;
        }
    }
}
