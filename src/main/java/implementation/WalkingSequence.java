/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4929
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class WalkingSequence {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            List<Integer> numberList1 = parseNumberList(bufferedReader);
            if (numberList1.isEmpty()) {
                break;
            }
            List<Integer> numberList2 = parseNumberList(bufferedReader);

            stringBuilder.append(solution(numberList1, numberList2)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static List<Integer> parseNumberList(BufferedReader bufferedReader) throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        List<Integer> numberList = new ArrayList<>();

        int length = Integer.parseInt(stringTokenizer.nextToken());

        if (length == 0) {
            return Collections.emptyList();
        }

        for (int i = 0; i < length; i++) {
            numberList.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        return numberList;
    }

    private static int solution(List<Integer> numberList1, List<Integer> numberList2) {
        int result = 0;
        int startIndex1 = 0;
        int startIndex2 = 0;

        for (int i = 0; i < numberList1.size(); i++) {
            int searchIndex = Collections.binarySearch(numberList2, numberList1.get(i));
            if (searchIndex > -1) {
                int sum1 = calculateSum(numberList1, startIndex1, i);
                int sum2 = calculateSum(numberList2, startIndex2, searchIndex);
                result += Math.max(sum1, sum2);

                startIndex1 = i + 1;
                startIndex2 = searchIndex + 1;
            }

        }
        int remainSum1 = calculateSum(numberList1, startIndex1, numberList1.size() - 1);
        int remainSum2 = calculateSum(numberList2, startIndex2, numberList2.size() - 1);

        result += Math.max(remainSum1, remainSum2);

        return result;
    }

    private static int calculateSum(List<Integer> numberList, int startIndex, int endIndex) {
        int sum = 0;

        if (startIndex >= numberList.size()) {
            return 0;
        }

        for (int id = startIndex; id < endIndex + 1; id++) {
            sum += numberList.get(id);
        }

        return sum;
    }
}
