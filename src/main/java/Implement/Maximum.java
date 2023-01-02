/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2562
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Maximum {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < 9; i++) integerList.add(Integer.parseInt(bufferedReader.readLine()));

        int maximum = getMaximum(integerList);
        int index = getIndex(integerList, maximum);

        System.out.println(maximum);
        System.out.println(index + 1);
    }

    public static int getMaximum(List<Integer> integerList) {
        return Collections.max(integerList);
    }

    public static int getIndex(List<Integer> integerList, int number) {
        return integerList.indexOf(number);
    }
}
