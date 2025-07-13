/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 21756
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Eraser {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(solution(Integer.parseInt(bufferedReader.readLine())));
    }

    private static int solution(int length) {
        List<Integer> numberList = IntStream.rangeClosed(1, length)
                .boxed()
                .collect(Collectors.toList());

        while (numberList.size() > 1) {
            List<Integer> erasedNumbers = IntStream.range(0, numberList.size())
                    .filter(i -> i % 2 == 0)
                    .mapToObj(numberList::get)
                    .collect(Collectors.toList());
            numberList.removeAll(erasedNumbers);
        }

        return numberList.get(0);
    }
}
