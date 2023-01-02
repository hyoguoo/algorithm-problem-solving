/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1003
 * Cheat Level: 2
 * Algorithm: Dynamic Programming
 */

package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FibonacciFunction {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        List<Integer> fibonacciList = new ArrayList<>();

        for (int i = 0; i < length; i++) fibonacciList.add(Integer.parseInt(bufferedReader.readLine()));
        Count count = getCount(Collections.max(fibonacciList));

        for (Integer integer : fibonacciList) System.out.println(count.zero[integer] + " " + count.one[integer]);
    }

    static Count getCount(int n) {
        Count count = new Count(n);

        for (int i = 2; i <= n; i++) {
            count.zero[i] = count.zero[i - 1] + count.zero[i - 2];
            count.one[i] = count.one[i - 1] + count.one[i - 2];
        }

        return count;
    }
}

class Count {
    public int[] zero;
    public int[] one;

    public Count(int length) {
        this.zero = new int[length + 2];
        this.one = new int[length + 2];
        this.zero[0] = this.one[1] = 1;
        this.zero[1] = this.one[0] = 0;
    }
}