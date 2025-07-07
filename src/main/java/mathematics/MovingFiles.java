/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11943
 * Cheat Level: 0
 * Algorithm: Mathematics / Implementation
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MovingFiles {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] basketInfo1 = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] basketInfo2 = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Basket basket1 = new Basket(basketInfo1[0], basketInfo1[1]);
        Basket basket2 = new Basket(basketInfo2[0], basketInfo2[1]);

        System.out.print(solution(basket1, basket2));
    }

    public static int solution(Basket basket1, Basket basket2) {
        int moveOrangeFromFirst = basket1.orangeCount;
        int moveAppleFromSecond = basket2.appleCount;

        int moveAppleFromFirst = basket1.appleCount;
        int moveOrangeFromSecond = basket2.orangeCount;

        return Math.min(moveOrangeFromFirst + moveAppleFromSecond, moveAppleFromFirst + moveOrangeFromSecond);
    }

    static class Basket {

        private final int appleCount;
        private final int orangeCount;

        public Basket(int appleCount, int orangeCount) {
            this.appleCount = appleCount;
            this.orangeCount = orangeCount;
        }
    }
}
