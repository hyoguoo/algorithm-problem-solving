/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2529
 * Cheat Level: 0
 * Algorithm: Brute Force / Backtracking
 */

package bruteforce.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InequalitySign {

    static final int MAX = 9;
    static final int MIN = 0;
    static String maxString = Long.MIN_VALUE + "";
    static String minString = Long.MAX_VALUE + "";

    public static void main(String[] args) throws IOException {
        solution(initializedSignList());
    }

    private static List<Sign> initializedSignList() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        List<Sign> signList = new ArrayList<>();
        String[] signs = bufferedReader.readLine().split(" ");

        for (String sign : signs) signList.add(Sign.of(sign.charAt(0)));

        return signList;
    }

    private static void solution(List<Sign> signList) {
        backtracking(new ArrayList<>(), signList);
        System.out.print(maxString + "\n" + minString);
    }

    private static void backtracking(List<Integer> numbers, List<Sign> signList) {
        if (numbers.size() > signList.size()) {
            String numberString = concatenateIntegerList(numbers);
            if (Long.parseLong(numberString) < Long.parseLong(minString)) minString = numberString;
            if (Long.parseLong(numberString) > Long.parseLong(maxString)) maxString = numberString;
            return;
        }

        for (int number = MIN; number <= MAX; number++) {
            if (numbers.contains(number)) continue;
            if (numbers.isEmpty() ||
                compare(numbers.get(numbers.size() - 1), number, signList.get(numbers.size() - 1))) {
                numbers.add(number);
                backtracking(numbers, signList);
                numbers.remove(numbers.size() - 1);
            }
        }
    }

    private static boolean compare(int previous, int current, Sign sign) {
        return sign.compare(previous, current);
    }

    private static String concatenateIntegerList(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    enum Sign {
        LESS('>') {
            @Override
            public boolean compare(int previous, int current) {
                return previous > current;
            }
        },
        GREATER('<') {
            @Override
            public boolean compare(int previous, int current) {
                return previous < current;
            }
        };

        final char signValue;

        Sign(char signValue) {
            this.signValue = signValue;
        }

        public static Sign of(char signValue) {
            return Arrays.stream(Sign.values())
                    .filter(sign -> sign.signValue == signValue)
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }

        abstract boolean compare(int previous, int current);
    }
}
