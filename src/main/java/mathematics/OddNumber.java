/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2576
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class OddNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 7; i++) numbers.add(Integer.parseInt(bufferedReader.readLine()));

        ArrayList<Integer> oddNumbers = filterEvenNumber(numbers);
        if (oddNumbers.size() == 0) {
            System.out.println("-1");
        } else {
            System.out.println(sumNumbers(oddNumbers));
            System.out.println(getMinNumber(oddNumbers));
        }
    }

    public static ArrayList<Integer> filterEvenNumber(ArrayList<Integer> numbers) {
        ArrayList<Integer> oddNumbers = new ArrayList<>();

        for (int number : numbers) {
            if (number % 2 != 0) oddNumbers.add(number);
        }

        return oddNumbers;
    }

    public static int sumNumbers(ArrayList<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers)
            sum += number;

        return sum;
    }

    public static int getMinNumber(ArrayList<Integer> numbers) {
        Collections.sort(numbers);
        return numbers.get(0);
    }

}
